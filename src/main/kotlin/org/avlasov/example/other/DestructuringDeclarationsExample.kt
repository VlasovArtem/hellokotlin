package org.avlasov.example.other

import org.junit.Assert.assertEquals

/**
 *   Created By artemvlasov on 2018-10-23
 **/
class DestructuringDeclarationsExample {

    fun verifyDestructuring() {
        val (name, age, _) = User("John Doe", 23)
        val (nameData, ageData) = UserData("Jane Doe", 32)
        verifyUserData("John Doe" to 23, name to age)
        verifyUserData("Jane Doe" to 32, nameData to ageData)
    }

    fun verifyDestructuringList() {
        val firstUser = User("New John Doe", 30)
        val secondUser = User("New Jane Doe", 33)
        val listOfUsers = listOf(firstUser, secondUser)
        for ((listName, listAge) in listOfUsers) {
            if (firstUser.name == listName) {
                verifyUserData(firstUser.name to firstUser.age, listName to listAge)
            } else if (secondUser.name == listName) {
                verifyUserData(secondUser.name to secondUser.age, listName to listAge)
            }
        }
    }

    fun verifyDestructuringMap() {
        val firstPair = "John Doe" to 33
        val secondPair = "Jane Doe" to 44
        val mapOf = mapOf(firstPair, secondPair)
        for ((name, age) in mapOf) {
            if (name == firstPair.first)
                verifyUserData(firstPair, name to age)
            else if (name == secondPair.first)
                verifyUserData(secondPair, name to age)
        }
    }

    fun verifyDestructuringMapLambda() {
        val firstPair = "John Doe" to 33
        val secondPair = "Jane Doe" to 44
        val mapOf = mapOf(firstPair, secondPair)
        val filteredMap = mapOf.filter { (name: String, _: Int) -> name.contains("John") }
        assertEquals(1, filteredMap.size)
        for ((name, age) in mapOf) {
            if (name == firstPair.first)
                verifyUserData(firstPair, name to age)
            else if (name == secondPair.first)
                verifyUserData(secondPair, name to age)
        }
    }

    fun verifyUserData(expected: Pair<String, Int>, actual: Pair<String, Int>) {
        assertEquals(expected.first, actual.first)
        assertEquals(expected.second, actual.second)
    }

}

class User(val name: String, val age: Int) {

    var location: String = ""

    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = location
}

data class UserData(val name: String, val age: Int)

fun main(args: Array<String>) {
    with(DestructuringDeclarationsExample()) {
        verifyDestructuring()
        verifyDestructuringList()
        verifyDestructuringMap()
        verifyDestructuringMapLambda()
    }
}