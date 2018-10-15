package org.avlasov.`when`

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class WhenExampleApp {

    fun describe(any: Any): String =
        when (any) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

}

fun main(args: Array<String>) {
    val whenExampleApp = WhenExampleApp()
    assert("One" == whenExampleApp.describe(1))
    assert("Not a string" == whenExampleApp.describe(2.0))
    assert("Long" == whenExampleApp.describe(1L))
    assert("Unknown" == whenExampleApp.describe("test"))
}