package org.avlasov.idioms.generic

/**
 *   Created By artemvlasov on 2018-10-16
 **/
class GenericExample {

    inline fun <reified T: Any> test(generic: T): Class<T> {
        return T::class.java
    }

}

fun main(args: Array<String>) {
    val genericExample = GenericExample()
    val test = genericExample.test(listOf("test"))
    println(test)
}
