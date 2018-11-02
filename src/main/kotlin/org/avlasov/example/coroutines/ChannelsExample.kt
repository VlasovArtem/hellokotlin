package org.avlasov.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation

/**
 *   Created By artemvlasov on 2018-10-31
 *   https://kotlinlang.org/docs/reference/coroutines/channels.html
 **/
class ChannelsExample {

    fun channelExample() = runBlocking {
        val channel = Channel<Int>()
        launch {
            // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
            for (x in 1..5) channel.send(x * x)
        }
// here we print five received integers:
        repeat(5) { println(channel.receive()) }
        println("Done!")
    }

    fun closeAndIterateChannels() = runBlocking {
        val channel = Channel<Int>()
        launch {
            for (x in 1..5) channel.send(x * x)
            channel.close() // we're done sending
        }
// here we print received values using `for` loop (until the channel is closed)
        for (y in channel) println(y)
        println("Done!")
    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    fun channelsProducerExample() = runBlocking {
        val squares = produceSquares()
        squares.consumeEach { print("$it, ") }
        println("Done!")
    }

    @ExperimentalCoroutinesApi
    @IgnoreMethod
    fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
        for (x in 1..5) send(x * x)
    }

    @ExperimentalCoroutinesApi
    fun pipelineExample() = runBlocking {
        val numbers = produceNumbers() // produces integers from 1 and on
        val squares = square(numbers) // squares integers
        for (i in 1..5) println(squares.receive()) // print first five
        println("Done!") // we are done
        coroutineContext.cancelChildren() // cancel children coroutines
    }

    @ExperimentalCoroutinesApi
    @IgnoreMethod
    fun CoroutineScope.produceNumbers(from: Int = 1) = produce {
        var x = from
        while (true) send(x++) // infinite stream of integers starting from 1
    }

    @ExperimentalCoroutinesApi
    @IgnoreMethod
    fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
        for (x in numbers) send(x * x)
    }

    @ExperimentalCoroutinesApi
    fun primePipeline() = runBlocking {
        var cur = produceNumbers(2)
        for (i in 1..10) {
            val prime = cur.receive()
            println(prime)
            cur = filter(cur, prime)
        }
        coroutineContext.cancelChildren()
    }

    @ExperimentalCoroutinesApi
    @IgnoreMethod
    fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce {
        for (x in numbers) if (x % prime != 0) send(x)
    }

    @ExperimentalCoroutinesApi
    @IgnoreMethod
    fun CoroutineScope.produceDelayNumber(from: Int = 1) = produce {
        var x = from
        while (true) {
            send(x++)
            delay(100)
        }
    }

    @IgnoreMethod
    fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
        for (msg in channel) {
            println("Processor #$id received $msg")
        }
    }

    @ExperimentalCoroutinesApi
    fun fanOut() = runBlocking {
        val producer = produceNumbers()
        repeat(5) { launchProcessor(it, producer) }
        delay(50)
        producer.cancel() // cancel producer coroutine and thus kill them all
    }

    fun fanIn() = runBlocking {
        val channel = Channel<String>()
        launch { sendString(channel, "foo", 200L) }
        launch { sendString(channel, "BAR!", 500L) }
        repeat(6) { // receive first six
            println(channel.receive())
        }
        coroutineContext.cancelChildren() // cancel all children to let main finish
    }

    @IgnoreMethod
    suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
        while (true) {
            delay(time)
            channel.send(s)
        }
    }

    fun bufferedChannel() = runBlocking {
        val channel = Channel<Int>(4) // create buffered channel
        val sender = launch { // launch sender coroutine
            repeat(10) {
                println("Sending $it") // print before sending each element
                channel.send(it) // will suspend when buffer is full
            }
        }
// don't receive anything... just wait....
        delay(1000)
        sender.cancel() // cancel sender coroutine
    }

    data class Ball(var hits: Int)

    fun ball() = runBlocking {
        val table = Channel<Ball>() // a shared table
        launch { player("ping", table) }
        launch { player("pong", table) }
        table.send(Ball(0)) // serve the ball
        delay(1000) // delay 1 second
        coroutineContext.cancelChildren() // game over, cancel them
    }

    @IgnoreMethod
    private suspend fun player(name: String, table: Channel<Ball>) {
        for (ball in table) { // receive the ball in a loop
            ball.hits++
            println("$name $ball")
            delay(300) // wait a bit
            table.send(ball) // send the ball back
        }
    }

    annotation class IgnoreMethod

}

fun main(args: Array<String>) {
    with(ChannelsExample()) {
        val declaredFunctions = this::class.declaredFunctions
        for (function in declaredFunctions) {
            val ignore = function.findAnnotation<ChannelsExample.IgnoreMethod>()
            if (ignore == null) {
                println("====================== ${function.name}")
                function.call(this)
                println("======================")
                println()
            }
        }
    }
}