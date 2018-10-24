package org.avlasov.example.idioms.defaultvalue

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-16
 **/
class DefaultFunctionValue {

    fun defaultValue(first: String = "default", second: Int = 0): Pair<String, Int> {
        return Pair(first, second)
    }

}

fun main(args: Array<String>) {
    val defaultFunctionValue = DefaultFunctionValue()
    val defaultValue = defaultFunctionValue.defaultValue(second = 20)
    assertEquals("default", defaultValue.first)
    assertEquals(20, defaultValue.second)
    val defaultValue1 = defaultFunctionValue.defaultValue(first = "test")
    assertEquals("test", defaultValue1.first)
    assertEquals(0, defaultValue1.second)
    val defaultValue2 = defaultFunctionValue.defaultValue("test2", 30)
    assertEquals("test2", defaultValue2.first)
    assertEquals(30, defaultValue2.second)
}