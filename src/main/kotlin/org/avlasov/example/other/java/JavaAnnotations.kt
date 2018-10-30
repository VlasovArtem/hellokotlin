package org.avlasov.example.other.java

import java.io.IOException
import java.security.Provider

/**
 *   Created By artemvlasov on 2018-10-30
 **/
class Key(val value: Int) {
    companion object {
        @JvmField val COMPARATOR: Comparator<Key> = compareBy { it.value }
    }
}

object Singleton {
    lateinit var provider: Provider
}

object Obj {
    const val CONST = 1
}

class C {
    companion object {
        const val VERSION = 9
    }
}

const val MAX = 239

class JmvStatic {
    companion object {
        @JvmStatic fun foo() {}
        fun bar() {}
    }
}

@Throws(IOException::class)
fun testThrows() {
    throw IOException()
}

fun testNotNull(str: String) = str.length

