package org.avlasov.loop

import org.junit.Assert.assertEquals

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

}

fun main(args: Array<String>) {
    val loopExampleApp = LoopExampleApp()
    assertEquals(15, loopExampleApp.loop(listOf("test", "test2", "test23")))
    assertEquals(6, loopExampleApp.loopIndices(listOf("123", "1", "54")))
    assertEquals(5, loopExampleApp.whileLoop(listOf("he", "llo")))
}