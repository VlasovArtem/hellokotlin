package org.avlasov.function

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-12
 **/
open class OpenClass {
    open fun plusOne(first: Int = 10, second: Int = 10): Int = first + second + 1
}

class OriginalClass : OpenClass() {
    override fun plusOne(first: Int, second: Int): Int = super.plusOne(first, second)
}

fun varargExample(vararg strings: String): Int = strings.size

infix fun Int.shl2(x: Int): Int = x + 1

class FunctionExampleApp {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sumExpression(a: Int, b: Int): Int = a + b

    fun sumVoid(a: Int, b: Int): Unit = println("Sum of $a and $b is ${a + b}")

    fun sumVoidWithReturn(a: Int, b: Int) = println("Sum of $a and $b is ${a + b}")

}

fun main(arg: Array<String>) {
    val functionExample = FunctionExampleApp()
    val sum = functionExample.sum(4, 5)
    assertEquals(9, sum)
    val sumExpression = functionExample.sumExpression(4, 5)
    assertEquals(9, sumExpression)
    functionExample.sumVoid(4, 5)
    functionExample.sumVoidWithReturn(4, 5)
    assertEquals(12, OriginalClass().plusOne(second = 1))
    assertEquals(23, OriginalClass().plusOne(22, 0))
    assertEquals(3, varargExample(strings = *arrayOf("test", "test2", "test3")))
    assertEquals(3, 1 shl2 2)
    assertEquals(3, 1.shl2(2))
}