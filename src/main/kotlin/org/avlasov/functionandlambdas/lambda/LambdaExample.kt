package org.avlasov.functionandlambdas.lambda

import org.hamcrest.collection.IsCollectionWithSize
import org.hamcrest.core.IsCollectionContaining
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat

/**
 *   Created By artemvlasov on 2018-10-22
 **/
fun externalFilter(s: String) = s == "test"

fun filterString(strings: List<String>, filter: (String) -> Boolean): List<String> = strings.filter { filter(it) }

val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}
val twoParameters: (String, Int) -> String = repeatFun
fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}
val plusString: (String, String) -> String = String::plus
val plusInt: (Int, Int) -> Int = Int::plus

fun intsSum(ints: Array<Int>, filter: (Int) -> Boolean): Int {
    var sum = 0
    ints.forEach { if (filter(it)) sum += it }
    return sum
}

val plusSum: Int.(Int) -> Int = { other -> plus(other) }
val anotherPlusSum = fun Int.(other : Int): Int = this + other

fun main(args: Array<String>) {
    val filterString = filterString(listOf("test", "test2", "hello")) { str -> "hello" != str }
    assertThat(filterString, IsCollectionWithSize.hasSize(2))
    assertThat(filterString, IsCollectionContaining.hasItems("test", "test2"))
    val filterString2 = filterString(listOf("test", "test2", "hello"), fun(s: String) = "hello" == s)
    assertThat(filterString2, IsCollectionWithSize.hasSize(1))
    assertThat(filterString2, IsCollectionContaining.hasItems("hello"))
    val filterString3 = filterString(listOf("test", "test2", "hello"), ::externalFilter)
    assertThat(filterString3, IsCollectionWithSize.hasSize(1))
    assertThat(filterString3, IsCollectionContaining.hasItems("test"))
    assertEquals("hellohellohello", runTransformation(repeatFun))
    assertEquals("hellohellohello", runTransformation(twoParameters))
    assertEquals("testtest", repeatFun.invoke("test", 2))
    assertEquals("test1test1", repeatFun("test1", 2))
    assertEquals("test1test1", "test1".repeatFun(2))
    assertEquals("Hello, world!", plusString("Hello, ", "world!"))
    assertEquals("testtest", (fun(str: String, times: Int) = str.repeat(times)).invoke("test", 2))
    assertEquals(5, plusInt(2, 3))
    mapOf("test" to "test2").forEach {_, value -> println(value)}
    assertEquals(10, intsSum(arrayOf(1, 5, 10)) {it -> it % 2 == 0})
    assertEquals(6, intsSum(arrayOf(1, 5, 10)) {it -> it % 2 != 0})
    assertEquals(19, plusSum(10, 9))
    assertEquals(10, 1.plusSum(9))
    assertEquals(19, anotherPlusSum(10, 9))
    assertEquals(10, 1.anotherPlusSum(9))
}