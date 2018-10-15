package org.avlasov.ranges

import org.junit.Assert.*

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class RangesExampleApp {

    fun inRange(from: Int, to: Int, value: Int): Boolean {
        if (from > to+1) return false
        return value in from..to+1
    }

    fun outRange(list: List<String>, number: Int): Boolean {
        return number !in 0..(list.size - 1)
    }

    fun sumRange(from: Int, to: Int): Int {
        if (from > to) return -1
        var sum = 0
        for (x in from..to)
            sum += x
        return sum
    }

    fun sumStepRange(from: Int, to: Int, step: Int): Int {
        if (from > to || step <= 0) return -1
        var sum = 0
        for (x in from..to step step)
            sum += x
        return sum
    }

}

fun main(args: Array<String>) {
    val rangesExampleApp = RangesExampleApp()
    assertTrue(rangesExampleApp.inRange(1, 5, 3))
    assertFalse(rangesExampleApp.inRange(6, 5, 3))
    assertFalse(rangesExampleApp.outRange(listOf("test", "test2"), 0))
    assertTrue(rangesExampleApp.outRange(listOf("test", "test2"), 2))
    assertEquals(55, rangesExampleApp.sumRange(1, 10))
    assertEquals(-1, rangesExampleApp.sumRange(10, 1))
    assertEquals(30, rangesExampleApp.sumStepRange(0, 10, 2))
    assertEquals(-1, rangesExampleApp.sumStepRange(10, 0, 2))
    assertEquals(-1, rangesExampleApp.sumStepRange(0, 10, -1))
}