package org.avlasov.classes.constructor.inheritance

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-18
 **/
fun main(args: Array<String>) {
    val child = Child("test")
    assertEquals("test", child.name)
    assertEquals("Child", child.info())
    assertEquals("child x", child.x)
    val parent = Parent("test")
    assertEquals("test", parent.name)
    assertEquals("Parent", parent.info())
    assertEquals("parent x", parent.x)
}