package org.avlasov.example.variable

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class App

fun main(args: Array<String>) {
    val a = 5
    var b = 0
    println(a + ++b)
    assert(a + ++b == 7)
}