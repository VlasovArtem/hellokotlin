package org.avlasov.example.controlflow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class IfExample {


    fun maxWithDefaultIf(a: Int, b: Int): Int {
        var max = a
        if (b > a)
            max = b
        return max
    }

    fun maxWithElseIf(a: Int, b: Int): Int {
        val max: Int
        if (a > b)
            max = a
        else
            max = b
        return max
    }

    // Else block is required for expression
    fun maxWithExpression(a: Int, b: Int): Int = if (a > b) a else b

}

fun main(args: Array<String>) {
    val ifExample = IfExample()
    assertEquals(5, ifExample.maxWithDefaultIf(5, 3))
    assertEquals(10, ifExample.maxWithElseIf(5, 10))
    assertNotEquals(3, ifExample.maxWithExpression(3, 5))
}