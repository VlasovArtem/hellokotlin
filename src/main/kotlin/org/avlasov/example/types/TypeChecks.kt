package org.avlasov.example.types

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

/**
 *   Created By artemvlasov on 2018-10-12
 **/
open class TypeChecks {

    open val openVal: String = "test"
    val customGetterVal: Int
        get() = 10

    fun getLength(any: Any): Int? {
        if (any is String) {
//            (any as String).length - is not required smart cast will be preformed
            return any.length
        } else if (any is Int)
            return any
        return null
    }

}

fun main(args: Array<String>) {
    val typeChecks = TypeChecks()
    assertEquals(4, typeChecks.getLength("test"))
    assertEquals(5, typeChecks.getLength(5))
    assertNull(typeChecks.getLength(2.9))
    println(typeChecks.getLength(typeChecks.openVal))
    println(typeChecks.getLength(typeChecks.customGetterVal))
}