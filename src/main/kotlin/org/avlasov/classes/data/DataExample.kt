package org.avlasov.classes.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

/**
 *   Created By artemvlasov on 2018-10-15
 *   https://kotlinlang.org/docs/reference/data-classes.html
 **/
data class DataExample(val firstName: String, val lastName: String, val email: String) {
    var age: Int = 0
}

fun main(args: Array<String>) {
    val dataExample = DataExample("firstName", "lastName", "test@email.com")
    assertEquals(DataExample("firstName", "lastName", "test@email.com"), dataExample)
    assertEquals(DataExample("firstName", "lastName", "test@email.com").hashCode(), dataExample.hashCode())
    assertEquals("firstName", dataExample.component1())
    assertEquals("lastName", dataExample.component2())
    assertEquals("test@email.com", dataExample.component3())
    assertNotEquals("lastName", dataExample.component3())
    assertEquals("DataExample(firstName=firstName, lastName=lastName, email=test@email.com)", dataExample.toString())
    assertEquals(0, dataExample.age)
    dataExample.age = 20
    assertEquals(20, dataExample.age)
    val dataExampleCopy = dataExample.copy()
    assertEquals(dataExample.email, dataExampleCopy.email)
    val dataExampleCopyWithNewEmail = dataExample.copy(email = "new@email.com")
    assertNotEquals(dataExample.email, dataExampleCopyWithNewEmail.email)
    val (firstName, lastName, email) = dataExample
    assertEquals("firstName", firstName)
    assertEquals("lastName", lastName)
    assertEquals("test@email.com", email)
}