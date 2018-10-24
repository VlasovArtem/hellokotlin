package org.avlasov.example.`object`

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import java.util.stream.Collectors

/**
 *   Created By artemvlasov on 2018-10-21
 **/
open class A(x : Int) {
    open val y: Int = x
}

interface B {

    fun planB(): Int

}

class Example private constructor() {
    companion object Factory {
        fun create() = Example()
    }
}

object SingletonClass {
    var count = 0
    init {
        count++
    }
}

interface Factory<T> {
    fun create() : T
}

class FactoryUser private constructor() {

    companion object : Factory<FactoryUser> {
        override fun create(): FactoryUser = FactoryUser()
    }

}

fun main(args: Array<String>) {
    val ab : A = object : A(1), B {
        override val y: Int = 15
        override fun planB(): Int = 10
    }
    val sorted = listOf(2, 1, 3).stream().sorted(object : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            if (o1 != null && o2 != null) {
                return Integer.compare(o1, o2)
            }
            return 0
        }

    })
        .collect(Collectors.toList())
    val objectTest = object {
        val x = 10
        val y = 20
    }

    assertEquals(listOf(1, 2, 3), sorted)
    assertEquals(15, ab.y)
    assertEquals(10, (ab as B).planB())
    assertEquals(10, objectTest.x)
    assertEquals(20, objectTest.y)
    assertNotEquals(Example.create(), Example.create())
    assertEquals(SingletonClass, SingletonClass)
    assertEquals(SingletonClass.count, SingletonClass.count)
    assertNotEquals(FactoryUser.create(), FactoryUser.create())
}