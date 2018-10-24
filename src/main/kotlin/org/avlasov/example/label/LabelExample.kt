package org.avlasov.example.label

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class LabelExample {

    fun originalReturn(): Int {
        var sum = 0
        intArrayOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return sum
            else
                sum += it
        }
        return 10
    }

    fun labelReturn(): Int {
        var sum = 0
        intArrayOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach
            else
                sum += it
        }
        return sum
    }

    fun customLabelReturn(): Int {
        var sum = 0
        intArrayOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit
            else
                sum += it
        }
        return sum
    }

    fun runLoopLabelReturn(): Int {
        var sum = 0
        run loop@ {
            intArrayOf(1, 2, 3, 4, 5).forEach{
                if (it == 3) return@loop
                else
                    sum += it
            }
        }
        return sum
    }

}

fun main(args: Array<String>) {
    val labelExample = LabelExample()
    assertEquals(3, labelExample.originalReturn())
    assertEquals(12, labelExample.labelReturn())
    assertEquals(12, labelExample.customLabelReturn())
    assertEquals(3, labelExample.runLoopLabelReturn())
}