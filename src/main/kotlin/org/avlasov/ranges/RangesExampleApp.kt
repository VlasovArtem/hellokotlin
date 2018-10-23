package org.avlasov.ranges

import org.junit.Assert.*

/**
 *   Created By artemvlasov on 2018-10-12
 *   https://kotlinlang.org/docs/reference/ranges.html
 **/
class RangesExampleApp {

    fun inRange(from: Int, to: Int, value: Int): Boolean {
        if (from > to+1) return false
        return value in from..to+1
    }

    fun inDownRange(from: Int, to: Int, value: Int): Boolean {
        if (from > to+1) return false
        return value in to+1 downTo from
    }

    fun notIncludeInRange(from: Int, to: Int, value: Int): Boolean {
        if (from > to+1) return false
        return value in from until to
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

    fun sumRangeTo(start: Int, end: Int): Int {
        var sum = 0
        start.rangeTo(end).forEach { sum += it }
        return sum
    }

    fun sumDownTo(end: Int): Int {
        var sum = 0
        end.downTo(0).forEach { sum += it }
        return sum
    }

}

val rangesExampleApp = RangesExampleApp()

fun verifyInRange() {
    assertTrue(rangesExampleApp.inRange(1, 5, 3))
    assertFalse(rangesExampleApp.inRange(6, 5, 3))
}

fun verifyInDownRange() {
    assertTrue(rangesExampleApp.inDownRange(1, 5, 3))
    assertFalse(rangesExampleApp.inDownRange(6, 5, 3))
}

fun verifyOutRange() {
    assertFalse(rangesExampleApp.outRange(listOf("test", "test2"), 0))
    assertTrue(rangesExampleApp.outRange(listOf("test", "test2"), 2))
}

fun verifySumRange() {
    assertEquals(55, rangesExampleApp.sumRange(1, 10))
    assertEquals(-1, rangesExampleApp.sumRange(10, 1))
}

fun verifySumStepRange() {
    assertEquals(30, rangesExampleApp.sumStepRange(0, 10, 2))
    assertEquals(-1, rangesExampleApp.sumStepRange(10, 0, 2))
    assertEquals(-1, rangesExampleApp.sumStepRange(0, 10, -1))
}

fun verifyNotIncludeInRange() {
    assertFalse(rangesExampleApp.notIncludeInRange(0, 100, 100))
}

fun verifySumRangeTo() {
    assertEquals(21, rangesExampleApp.sumRangeTo(1, 6))
}

fun verifySumDownTo() {
    assertEquals(10, rangesExampleApp.sumDownTo(4))
}

fun verifyProgressionReversed() {
    val intProgression = 1 downTo 10
    val reversed: IntProgression = intProgression.reversed()
    assertEquals(intProgression.first, reversed.last)
}

fun verifyProgressionStep() {
    val start = 1
    val rangeTo = start.rangeTo(10)
    assertEquals(55, rangeTo.sum())
    assertEquals(25, rangeTo.step(2).sum())
}

fun main(args: Array<String>) {
    verifyInRange()
    verifyInDownRange()
    verifyOutRange()
    verifySumRange()
    verifySumStepRange()
    verifyNotIncludeInRange()
    verifySumRangeTo()
    verifySumDownTo()
    verifyProgressionReversed()
    verifyProgressionStep()
}