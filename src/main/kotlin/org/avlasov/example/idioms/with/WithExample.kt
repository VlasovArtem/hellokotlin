package org.avlasov.example.idioms.with

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-16
 **/
class WithExample {

    fun add(a: Int, b: Int): Int = a + b
    fun subtract(a: Int, b: Int): Int = a - b
    fun multiply(a: Int, b: Int): Int = a * b
    fun divide(a: Int, b: Int): Int = a / b

}

fun main(args: Array<String>) {
    val withExample = WithExample()
    var result = 0
    with(withExample) {
        result =
                divide(
                    multiply(
                        subtract(
                            add(5, 5), 2
                        ), 20
                    ), 2
                )
    }
    assertEquals(80, result)
}