package org.avlasov.function

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-12
 **/
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
}