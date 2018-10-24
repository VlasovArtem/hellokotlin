package org.avlasov.example.classes.constructor

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class ConstructorExample(var name: String, lastName: String) {

    var age = 0
    var location: String = ""
    var lastName = lastName

    init {
        location = "Unknown Location"
    }

    constructor(name: String, lastName: String, age: Int) : this(name, lastName) {
        this.age = age
    }

    constructor(name: String, lastName: String, location: String) : this(name, lastName) {
        this.location = location
    }

}

fun main(args: Array<String>) {
    val ce1 = ConstructorExample("first", "second")
    assertEquals("first", ce1.name)
    assertEquals("second", ce1.lastName)
    assertEquals(0, ce1.age)
    assertEquals("Unknown Location", ce1.location)
    val ce2 = ConstructorExample("first", "second", 99)
    assertEquals("first", ce2.name)
    assertEquals("second", ce2.lastName)
    assertEquals(99, ce2.age)
    assertEquals("Unknown Location", ce2.location)
    val ce3 = ConstructorExample("first", "second", "location")
    assertEquals("first", ce3.name)
    assertEquals("second", ce3.lastName)
    assertEquals(0, ce3.age)
    assertEquals("location", ce3.location)
}

