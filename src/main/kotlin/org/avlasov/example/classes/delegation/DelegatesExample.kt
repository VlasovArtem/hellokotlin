package org.avlasov.example.classes.delegation

import org.junit.Assert.assertEquals
import kotlin.reflect.KProperty

/**
 *   Created By artemvlasov on 2018-10-21
 **/
interface Base {
    val message : String
    fun getMessageData(): String
    fun getInt() : Int
    fun getInt2() : Int
}

class BaseImpl(val x : Int) : Base {
    override val message: String = "Base Impl"
    override fun getMessageData(): String = message
    override fun getInt() = x
    override fun getInt2() = x
}

class DelegateBase(b : Base) : Base by b {
    override val message: String = "Delegate Base"
    override fun getInt(): Int = 25
}

class DelegateProperty {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : String = "Value with ${property.name}"
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) = "set $value"
}

class DelegatePropertyClass {
    var p : String by DelegateProperty()
}

val lazyValue : String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
    println("Computed")
    "Lazy"
}

fun main(args: Array<String>) {
    val baseImpl = BaseImpl(10)
    assertEquals(25, DelegateBase(baseImpl).getInt())
    assertEquals(10, DelegateBase(baseImpl).getInt2())
    assertEquals("Base Impl", baseImpl.message)
    assertEquals("Base Impl", DelegateBase(baseImpl).getMessageData())
    assertEquals("Delegate Base", DelegateBase(baseImpl).message)
    val delegatePropertyClass = DelegatePropertyClass()
    assertEquals("Value with p", delegatePropertyClass.p)
    assertEquals("Lazy", lazyValue)
}