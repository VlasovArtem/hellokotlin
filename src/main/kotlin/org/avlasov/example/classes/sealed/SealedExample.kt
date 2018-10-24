package org.avlasov.example.classes.sealed

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-19
 **/

sealed class Sealed

data class Const(val number: Double) : Sealed()
data class Sum(val sealed1: Sealed, val sealed2: Sealed) : Sealed()

object NotANumber : Sealed()

fun eval(sealed: Sealed) : Double = when (sealed) {
    is Const -> sealed.number
    is Sum -> eval(sealed.sealed1) + eval(sealed.sealed2)
    NotANumber -> Double.NaN
}

fun main(args: Array<String>) {
    assertEquals(10.0, eval(Const(10.0)), 0.0)
    assertEquals(15.0, eval(Sum(Const(10.0), Const(5.0))), 0.0)
    assertEquals(Double.NaN, eval(NotANumber), 0.0)
}