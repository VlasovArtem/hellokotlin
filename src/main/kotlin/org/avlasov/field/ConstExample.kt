package org.avlasov.field

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-19
 **/
object ConstClass {
    const val constVal = "const val value"
}

class ClassTest {
    companion object {
        const val companionConstVal = "companion const val value"
    }
}

fun main(args: Array<String>) {
    assertEquals("const val value", ConstClass.constVal)
//    ConstClass.constVal = "Test" - Won't work
    assertEquals("companion const val value", ClassTest.companionConstVal)
//    ConstClass.companionConstVal = "Test" - Won't work
}