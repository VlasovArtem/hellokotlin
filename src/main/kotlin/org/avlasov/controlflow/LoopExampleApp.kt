package org.avlasov.controlflow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class LoopExampleApp {

    fun loop(list: List<String>): Int {
        var itemsLength = 0
        for (item in list) {
            itemsLength += item.length
        }
        return itemsLength
    }

    fun loopIndices(list: List<String>): Int {
        var itemsLength = 0
        for (index in list.indices)
            itemsLength += list[index].length
        return itemsLength
    }

    fun whileLoop(list: List<String>): Int {
        var itemsLength = 0
        var index = 0
        while (index < list.size) {
            itemsLength += list[index].length
            index++
        }
        return itemsLength
    }

    fun loopWithIndex(array: Array<String>, startWith: String): Array<Int?> {
        val intArray = Array<Int?>(array.size) { null }
        var lastIndex = 0
        for ((index, value) in array.withIndex()) {
            if (value.startsWith(startWith))
                intArray[lastIndex++] = index
        }
        return intArray
    }

}

fun main(args: Array<String>) {
    val loopExampleApp = LoopExampleApp()
    assertEquals(15, loopExampleApp.loop(listOf("test", "test2", "test23")))
    assertEquals(6, loopExampleApp.loopIndices(listOf("123", "1", "54")))
    assertEquals(5, loopExampleApp.whileLoop(listOf("he", "llo")))
    val array = loopExampleApp.loopWithIndex(arrayOf("test", "hello", "world"), "h")
    assertEquals(1, array[0])
    assertNull(array[1])
    val arrayInt2 = loopExampleApp.loopWithIndex(arrayOf("test", "hello", "world"), "a")
    assertNull(arrayInt2[0])
}