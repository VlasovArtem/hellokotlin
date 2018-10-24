package org.avlasov.example.classes.override

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-18
 **/
open class A {
    open fun f() : String = "f class A"
}

interface B {
    fun f() : String = "f interface B"
    fun b() : String = "b interface B"
}

class C() : A(), B {

    override fun f(): String = "f class C" + " " + super<A>.f() + " " + super<B>.f()
}

fun main(args: Array<String>) {
    val c = C()
    assertEquals("f class C f class A f interface B", c.f())
}