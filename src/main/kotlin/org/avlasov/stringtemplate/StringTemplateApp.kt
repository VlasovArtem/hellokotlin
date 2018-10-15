package org.avlasov.stringtemplate

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-12
 **/
fun main(args: Array<String>) {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    assertEquals("a was 1, but now is 2", s2)
}