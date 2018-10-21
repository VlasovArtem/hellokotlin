package org.avlasov.generic

/**
 *   Created By artemvlasov on 2018-10-16
 **/
class GenericExample {

    inline fun <reified T: Any> test(generic: T): Class<T> {
        return T::class.java
    }

}

interface Source<T> {
    fun produce(): T
}

// Use only for produces (like PECS in Java producer is extends and consumer is super)
interface SourceOut<out T> {
    fun produce(): T
}

//Use only for consumers
interface SourceIn<in T> {
    fun consume(t: T): String
}

fun demo(strs: Source<String>, strsOut: SourceOut<String>, numbersIn: SourceIn<Number>) {
//    val objects: Source<Any> = strs - won't work, like in java
    val strings: Source<String> = strs
    val objectsOut: SourceOut<Any> = strsOut
    val stringsOut: SourceOut<String> = strsOut
    numbersIn.consume(2.0)
    numbersIn.consume(2)
    numbersIn.consume(2L)
    numbersIn.consume(2.0f)
}

fun main(args: Array<String>) {
    val genericExample = GenericExample()
    val test = genericExample.test(listOf("test"))
    println(test)
}
