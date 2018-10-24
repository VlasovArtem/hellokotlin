package org.avlasov.example.array

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

/**
 *   Created By artemvlasov on 2018-10-17
 *   Arrays in Kotlin is invariant. Array<String> cannot be assign to Array<Any>
 **/
fun main(args: Array<String>) {

    val arrayString = Array(5) { i -> (i * i).toString() }
    assertEquals("1", arrayString.get(1))
    assertEquals("4", arrayString[2])
//    val arrayAny: Array<Any> = arrayString
    val arrayAny: Array<out Any> = arrayString
    val intArray: Array<Int> = Array(5) { i -> i} //Boxed
    val intArrayNotBoxed: IntArray = intArrayOf(1, 2, 3, 4)
    assertTrue(intArray.contentEquals(arrayOf(0, 1, 2, 3, 4)))
    assertTrue(intArrayNotBoxed.contentEquals(intArrayOf(1, 2, 3, 4)))
    assertTrue(arrayAny.contentEquals(arrayOf("0", "1", "4", "9", "16")))
}