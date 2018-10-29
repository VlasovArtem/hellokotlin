package org.avlasov.example.other

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

/**
 *   Created By artemvlasov on 2018-10-29
 *   https://kotlinlang.org/docs/reference/reflection.html
 **/
class ReferenceExample {

    val x = 10
    var y = 10

    fun getKClass(any: Any): KClass<*> = any::class

    fun isOdd(x: Int) = x % 2 == 0

    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x ->  f(g(x)) }
    }

    val String.lastChar: Char
        get() = this[length - 1]

    fun verifyClassReference() {
        assertTrue(getKClass("test") == String::class)
    }

    fun verifyFunctionReference() {
        val listOfNumber = listOf(1, 3, 6, 7, 8)
        val filter = listOfNumber.filter(::isOdd) //(Int) -> Boolean
//        listOfNumber.filter { it -> it % 2 == 0 }
        assertEquals(kotlin.collections.listOf(6, 8), filter)
    }

    fun verifyFunctionComposition() {
        fun length(s: String) = s.length
        val oddLength = compose(::isOdd, ::length)
        val listOfString = listOf("test", "hello", "test2", "test12")
        val oddString = listOfString.filter(oddLength)
        assertEquals(listOf("test", "test12"), oddString)
    }

    fun verifyPropertyReference() {
        assertEquals(10, ::x.get())
        assertEquals("x", this::x.name)
        assertTrue(::x.isFinal)
        assertEquals(10, ::y.get())
        ::y.set(15) // y = 15
        assertEquals(15, this::y.get())
        val listOfStrings = listOf("test", "test1", "test12")
        val listOfNumbers = listOfStrings.map(String::length)
        assertEquals(listOf(4, 5, 6), listOfNumbers)
        class TestA(val p: Int)
        val pProperty = TestA::p
        assertEquals(10, pProperty.get(TestA(10)))
        assertEquals('t', "test".lastChar)
    }

    fun verifyJavaReflection() {

        class TestReflection(val p: Int) {
            var c: Int = 0
            fun mainTest() {}
        }

        println(TestReflection::p.javaGetter)
        println(TestReflection::p.javaField)
        println(TestReflection::p.javaClass)
        println(TestReflection::p.javaClass)
        println(TestReflection::c.javaGetter)
        println(TestReflection::c.javaSetter)
        println(TestReflection::c.javaField)
        println(TestReflection::c.javaClass)
        println(TestReflection::c.javaClass.kotlin)
        println(TestReflection::mainTest.isFinal)
        println(TestReflection::mainTest.visibility)

    }

    fun verifyBoundReference() {
        val numberRegex = "\\d+".toRegex()
        assertTrue(numberRegex.matches("29"))
        val numberRegexMatcher = numberRegex::matches
        assertTrue(numberRegexMatcher("33"))
        val listOf = listOf("test", "123", "123a")
        assertEquals(listOf("123"), listOf.filter(numberRegex::matches))
        assertEquals(listOf("123"), listOf.filter(numberRegexMatcher))
        val lengthProperty = "test"::length
        assertEquals(4, lengthProperty.get())
    }

}

fun main(args: Array<String>) {
    with(ReferenceExample()) {
        verifyClassReference()
        verifyFunctionReference()
        verifyFunctionComposition()
        verifyPropertyReference()
        verifyJavaReflection()
        verifyBoundReference()
    }
}