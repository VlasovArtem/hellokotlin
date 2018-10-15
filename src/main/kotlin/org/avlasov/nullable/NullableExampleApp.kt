package org.avlasov.nullable

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class NullableExampleApp {

    fun add(arg1: String, arg2: String): Int? {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x != null && y != null)
            return x * y
        return null
    }

    private fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

}

fun main(args: Array<String>) {
    val nullableExampleApp = NullableExampleApp()
    val add = nullableExampleApp.add("1", "19")
    assert(add == 20)
    val nullValue = nullableExampleApp.add("1", "b")
    assert(nullValue == null)
    val nullValue1 = nullableExampleApp.add("a", "2")
    assert(nullValue1 == null)
}