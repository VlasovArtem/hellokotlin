package org.avlasov.classes.inline

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-21
 **/
interface IInterface {
    fun printSomething() : String
}

inline class IClass(val name: String) : IInterface {
    override fun printSomething(): String = "Name '$name'"
}

fun main(args: Array<String>) {
    val iClass = IClass("test name")
    assertEquals("Name 'test name'", iClass.printSomething())
}