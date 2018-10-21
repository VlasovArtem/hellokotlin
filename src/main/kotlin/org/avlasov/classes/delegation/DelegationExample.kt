package org.avlasov.classes.delegation

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-21
 **/
interface Base {
    val message : String
    fun getInt() : Int
    fun getInt2() : Int
}

class BaseImpl(val x : Int) : Base {
    override val message: String = "Base Impl"
    override fun getInt() = x
    override fun getInt2() = x
}

class DelegateBase(b : Base) : Base by b {
    override val message: String = "Delegate Base"
    override fun getInt(): Int = 25
}

fun main(args: Array<String>) {
    val baseImpl = BaseImpl(10)
    assertEquals(25, DelegateBase(baseImpl).getInt())
    assertEquals(10, DelegateBase(baseImpl).getInt2())
    assertEquals("Base Impl", baseImpl.message)
}