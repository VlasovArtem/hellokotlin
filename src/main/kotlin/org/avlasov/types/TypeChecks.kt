package org.avlasov.types

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class TypeChecks {

    fun getLength(any: Any): Int? {
        if (any is String)
            return any.length
        else if (any is Int)
            return any
        return null
    }

}

fun main(args: Array<String>) {
    val typeChecks = TypeChecks()
    assertEquals(4, typeChecks.getLength("test"))
    assertEquals(5, typeChecks.getLength(5))
    assertNull(typeChecks.getLength(2.9))
}