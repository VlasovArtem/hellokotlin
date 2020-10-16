package org.avlasov.example.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.avlasov.example.coroutines.annotation.IgnoreMethod
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation
import kotlin.system.measureTimeMillis

/**
 *   Created By artemvlasov on 2018-11-02
 *   https://kotlinlang.org/docs/reference/coroutines/composing-suspending-functions.html
 **/
class SuspendingFunctionExample {

    @IgnoreMethod
    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    @IgnoreMethod
    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }

    fun sequantialFunction() = runBlocking {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")
    }

    fun asyncFunction() = runBlocking {
        val time = measureTimeMillis {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

    fun lazyAsyncFunction() = runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            // some computation
            one.start() // start the first one
            two.start() // start the second one
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

}


fun main(args: Array<String>) {
    with(SuspendingFunctionExample()) {
        val declaredFunctions = this::class.declaredFunctions
        for (function in declaredFunctions) {
            val ignore = function.findAnnotation<IgnoreMethod>()
            if (ignore == null) {
                println("====================== ${function.name}")
                function.call(this)
                println("======================")
                println()
            }
        }
    }
}