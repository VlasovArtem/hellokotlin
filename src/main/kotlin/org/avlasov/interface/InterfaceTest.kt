package org.avlasov.`interface`

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-19
 **/
interface InterfaceTest {

    val abstractProperty: String

    fun abstractMethod(): String
    fun methodWithBody(): String  = "I have a body"

}

class ClassTest : InterfaceTest {

    override val abstractProperty: String = "Class Test"

    override fun abstractMethod(): String = "Class Method Implementation"

}

fun main(args: Array<String>) {

    val classTest = ClassTest()
    assertEquals("I have a body", classTest.methodWithBody())
    assertEquals("Class Method Implementation", classTest.abstractMethod())
    assertEquals("Class Test", classTest.abstractProperty)

}

