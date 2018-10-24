package org.avlasov.example.controlflow

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class WhenExampleApp {

    fun describe(any: Any): String =
        when (any) {
            1 -> "One"
            test(any) -> "Is Five"
            in 20..30 -> "In range between 20 and 30"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> any.capitalize()
        }

    fun test(any: Any): Int? {
        val toIntOrNull = any.toString().toIntOrNull()
        if (toIntOrNull != 5)
            return null
        return toIntOrNull
    }

}

fun main(args: Array<String>) {
    val whenExampleApp = WhenExampleApp()
    assertEquals("One", whenExampleApp.describe(1))
    assertEquals("Is Five", whenExampleApp.describe(5))
    assertEquals("In range between 20 and 30", whenExampleApp.describe(21))
    assertEquals("Not a string", whenExampleApp.describe(2.0))
    assertEquals("Long", whenExampleApp.describe(1L))
    assertEquals("Unknown", whenExampleApp.describe(Pair(1, 2)))
    assertEquals("Test", whenExampleApp.describe("test"))
}