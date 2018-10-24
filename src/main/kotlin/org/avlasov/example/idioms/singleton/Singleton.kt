package org.avlasov.example.idioms.singleton

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-16
 **/
object Singleton {

    const val name = "Name"

}

fun main(args: Array<String>) {
    assertEquals("Name", Singleton.name)
}