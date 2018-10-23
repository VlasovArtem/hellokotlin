package org.avlasov.other

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

/**
 *   Created By artemvlasov on 2018-10-23
 **/
data class DataClassExample(val name: String, val value: String)

fun main(args: Array<String>) {
    val first = DataClassExample("test", "test2")
    val second = DataClassExample("test", "test2")
    assertTrue(first == second) // first == second will be compiled to first?.equals(second) ?: (second === null)
    assertFalse(first === second) // first === second verify reference
    assertTrue(first === first)
    // 'a == null' will be automatically translated to 'a === null'
}