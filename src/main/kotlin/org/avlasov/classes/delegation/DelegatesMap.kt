package org.avlasov.classes.delegation

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-22
 **/
class UserData(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class MutableUserData(map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}


fun main(args: Array<String>) {
    val userData = UserData(
        mapOf(
            "name" to "John Doe",
            "age" to 10
        )
    )
    assertEquals(10, userData.age)
    assertEquals("John Doe", userData.name)
    val mutableUserData = MutableUserData(
        mutableMapOf(
            "name" to "John Doe",
            "age" to 10
        )
    )
    assertEquals(10, mutableUserData.age)
    assertEquals("John Doe", mutableUserData.name)
    mutableUserData.age = 30
    assertEquals(30, mutableUserData.age)
}