package org.avlasov.other

import org.junit.Assert.*
import java.io.File

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class NullableExampleApp {

    class Head
    class Department {
        var head: Head? = null
    }
    class Person(val department: Department?)

    private fun getHead(): Head = Head()

    fun verifyNullAssign() {
        var withOutNull: Person? = Person(Department())
        withOutNull?.department?.head = getHead()
        assertNotNull(withOutNull?.department?.head)
        withOutNull = null
        assertNull(withOutNull?.department?.head)
        withOutNull = Person(null)
        assertNull(withOutNull?.department?.head)
    }

    fun verifyElvisOperator() {
        var str: String? = "test"
        assertEquals(4, str?.length ?: -1)
        str = null
        assertEquals(-1, str?.length ?: -1)
    }

    fun verifyFileList() {
        fun ifNotNullListFilesSize(file: File): Int? {
            val files = file.listFiles()
            return files?.size
        }

        fun ifNotNullElseListFilesSize(file: File): Int {
            val files = file.listFiles()
            return files?.size ?: -1
        }
        val filesFolder = File("./files")
        val notExists = File("./notexists")
        assertEquals(1, ifNotNullListFilesSize(filesFolder))
        assertEquals(1, ifNotNullElseListFilesSize(filesFolder))
        assertNull(ifNotNullListFilesSize(notExists))
        assertEquals(-1, ifNotNullElseListFilesSize(notExists))
    }

    fun verifyAdd() {
        fun add(arg1: String, arg2: String): Int? {
            val x = parseInt(arg1)
            val y = parseInt(arg2)
            if (x != null && y != null)
                return x * y
            return null
        }
        val add = add("1", "19")
        assertEquals(19, add)
        val nullValue = add("1", "b")
        assertNull(nullValue)
        val nullValue1 = add("a", "2")
        assertNull(nullValue1)
    }

    fun verifyIfNotNull() {
        fun returnIfNotNull(value: String?): String {
            value?.let {
                return it.toUpperCase()
            }
            return "null"
        }
        assertEquals("TEST", returnIfNotNull("test"))
        assertEquals("null", returnIfNotNull(null))
    }

    fun verifyBooleanNull() {
        fun booleanNull(isBoolean: Boolean?): String {
            return if (isBoolean == true) {
                "true"
            } else {
                "false or null"
            }
        }
        assertEquals("true", booleanNull(true))
        assertEquals("false or null", booleanNull(false))
        assertEquals("false or null", booleanNull(null))
    }

    fun verifyNullCast() {
        fun convert(any: Any?): Int? = any as? Int
        assertNotNull(convert(10))
        assertNull(convert("test"))
    }

    private fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

}

fun main(args: Array<String>) {
    with(NullableExampleApp()) {
        verifyElvisOperator()
        verifyNullAssign()
        verifyFileList()
        verifyAdd()
        verifyIfNotNull()
        verifyBooleanNull()
        verifyNullCast()
    }
}