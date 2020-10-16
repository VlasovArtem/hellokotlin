package org.avlasov.example.extension

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import java.util.function.Predicate

/**
 *   Created By artemvlasov on 2018-10-19
 **/
fun List<String>.extension(predicate: Predicate<String>): String? =
    this.stream()
        .filter(predicate)
        .findFirst()
        .orElse(null)

open class A {
    fun bar() = "A bar"
}

class B : A() {
    fun initFoo() = "init foo"

    fun A.fooTest() = bar() + " " + initFoo()

    companion object {
        fun fooCompanion() = "companion"
    }

    fun caller(a: A) = a.fooTest()

}

fun showFoo(a : A) = a.foo()

fun A.foo() = "A"

fun B.foo() = "B"

fun B.initFoo() = "external init foo"

fun B.initFoo(int: Int) = "external init foo $int"

fun B.Companion.fooCompanion(int: Int) = "extension companion $int"


fun String.test() = "test"

fun main(args: Array<String>) {
    val listOf = listOf("test", "hello", "world")
    assertEquals("test", listOf.extension(Predicate { s -> s.startsWith("t") }))
    assertNull(listOf.extension(Predicate { s -> s.startsWith("f") }))
    assertEquals("A", showFoo(A()))
    assertEquals("A", showFoo(B()))
    assertEquals("init foo", B().initFoo())
    assertEquals("external init foo 2", B().initFoo(2))
    assertEquals("companion", B.fooCompanion())
    assertEquals("extension companion 5", B.fooCompanion(5))
    assertEquals("A bar", A().bar())
//    assertEquals"A bar init foo", A().fooTest())
    assertEquals("A bar init foo", B().caller(A()))
}