package org.avlasov.example.coroutines

import kotlinx.coroutines.*

/**
 *   Created By artemvlasov on 2018-10-30
 **/
class CoroutinesExample {
    fun nonBlockingAndBlocking() {
        GlobalScope.launch {
            delay(1000L) //suspend coroutine
            println("World!")
        }
        println("(nonBlockingAndBlocking) Hello,")
        Thread.sleep(2000L)
    }

    fun nonBlockingDelays() {
        GlobalScope.launch { // launch new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("(nonBlockingDelays) Hello,") // main thread continues here immediately
        runBlocking {     // but this expression blocks the main thread
            // runBlocking blocks main thread until code inside this block is running
            delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
        }
    }

    fun runBlockingFun() = runBlocking {
        GlobalScope.launch { // launch new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("(runBlockingFun) Hello,") // main coroutine continues here immediately
        delay(2000L)      // delaying for 2 seconds to keep JVM alive
    }

    fun runInnerCoroutine() = runBlocking { // this: CoroutineScope
        launch { // launch new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        println("(runInnerCoroutine) Hello,")
    }

    fun additionalCoroutine() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a new coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before nested launch
        }

        println("Coroutine scope is over") // This line is not printed until nested launch completes
    }

    fun callOuterMethod() = runBlocking {
        launch { suspendMethod() }
        println("(callOuterMethod) Hello,")
    }

    private suspend fun suspendMethod() {
        delay(1000L)
        println("World!")
    }

    fun manyCoroutines() = runBlocking {
        repeat(100_000) { // launch a lot of coroutines
            launch {
                delay(1000L)
                print(".")
            }
        }
    }

    fun coroutinesAreLikeDaemonThreads() = runBlocking {
        GlobalScope.launch {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // just quit after delay
    }

}

fun main(args: Array<String>) {
    with(CoroutinesExample()) {
        nonBlockingAndBlocking()
        nonBlockingDelays()
        runBlockingFun()
        runInnerCoroutine()
        additionalCoroutine()
        callOuterMethod()
//        manyCoroutines()
        coroutinesAreLikeDaemonThreads()
    }
}