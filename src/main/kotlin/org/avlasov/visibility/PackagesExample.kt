package org.avlasov.visibility

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-19
 **/
val ktProperty: String = "Top Level"

fun testFunction() = "Test function $ktProperty"

open class OpenClass {

    val publicVal = "Public Val"
    private val privateVal = "Private Val"
    internal val internalVal = "Internal Val"
    protected val protectedVal = "Protected Val"

    fun getData() = "Open class $ktProperty with $privateVal"

}

class OriginalClass : OpenClass() {

    fun getInfo() = protectedVal

}

fun main(args: Array<String>) {

    assertEquals("Top Level", ktProperty)
    assertEquals("Test function Top Level", testFunction())
    with(OpenClass()) {
        assertEquals("Open class Top Level Private Val", getData())
        assertEquals("Public Val", publicVal)
//        assertEquals("Private Val", privateVal) - won't work
        assertEquals("Internal Val", internalVal)
//        assertEquals("Protected Val", protectedVal) - won't work

    }
    assertEquals("Protected Val", OriginalClass().getInfo())
}

