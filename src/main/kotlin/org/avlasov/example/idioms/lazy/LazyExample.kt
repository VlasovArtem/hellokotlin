package org.avlasov.example.idioms.lazy

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-16
 **/
class LazyExample {

    val lazyA: String by lazy { "testA" }

}

fun main(args: Array<String>) {
    val lazyExample = LazyExample()
    assertEquals("testA", lazyExample.lazyA)
}