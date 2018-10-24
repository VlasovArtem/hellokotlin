package org.avlasov.example.idioms.map

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

/**
 *   Created By artemvlasov on 2018-10-16
 **/
fun main(args: Array<String>) {
    val mapOf = mapOf("a" to 1, "b" to 2, "c" to 3)
    assertEquals(1, mapOf.get("a"))
    assertNull(mapOf.get("d"))
    assertEquals(2, mapOf["b"])
    assertNull(mapOf["e"])
}