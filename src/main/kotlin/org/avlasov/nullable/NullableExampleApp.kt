package org.avlasov.nullable

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import java.io.File

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

    fun ifNotNullListFilesSize(file: File): Int? {
        val files = file.listFiles()
        return files?.size
    }

    fun ifNotNullElseListFilesSize(file: File): Int {
        val files = file.listFiles()
        return files?.size ?: -1
    }

    private fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

}

fun main(args: Array<String>) {
    val nullableExampleApp = NullableExampleApp()
    val add = nullableExampleApp.add("1", "19")
    assertEquals(19, add)
    val nullValue = nullableExampleApp.add("1", "b")
    assertNull(nullValue)
    val nullValue1 = nullableExampleApp.add("a", "2")
    assertNull(nullValue1)
    val filesFolder = File("./files")
    val notExists = File("./notexists")
    assertEquals(1, nullableExampleApp.ifNotNullListFilesSize(filesFolder))
    assertEquals(1, nullableExampleApp.ifNotNullElseListFilesSize(filesFolder))
    assertNull(nullableExampleApp.ifNotNullListFilesSize(notExists))
    assertEquals(-1, nullableExampleApp.ifNotNullElseListFilesSize(notExists))

}