package org.avlasov.classes.delegation

import org.junit.Assert.assertEquals
import kotlin.properties.Delegates

/**
 *   Created By artemvlasov on 2018-10-22
 **/
class User {
    var count = 0
    var name: String by Delegates.observable("<no name>") {
            prop, old, new -> println("Prop $prop, Old $old, new $new")
            count++
    }

    var age: Int by Delegates.vetoable(-1) {
        property, oldValue, newValue -> println("Prop $property, Old $oldValue, new $newValue")
        if (newValue >= 130)
            return@vetoable false
        true
    }

}

fun main(args: Array<String>) {
    val user = User()
    assertEquals(0, user.count)
    assertEquals("<no name>", user.name)
    assertEquals(-1, user.age)
    user.name = "new"
    user.age = 31
    assertEquals(1, user.count)
    assertEquals("new", user.name)
    assertEquals(31, user.age)
    user.name = "new2"
    user.age = 130
    assertEquals(2, user.count)
    assertEquals("new2", user.name)
    assertEquals(31, user.age)
}