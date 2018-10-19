package org.avlasov.field

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class PropertiesAndFieldsExample {

    var varValue = "var"
    var varGetterSetterValue: String = "abc"
        get() = field.toUpperCase()
        set(value) {
            field = value.capitalize()
        }
    val valValue = "val"
    var varPrivateSetterValue: String = "private"
        private set
    lateinit var lateInitVar: String
}

fun main(args: Array<String>) {
    val propertiesAndFieldsExample = PropertiesAndFieldsExample()
    with(propertiesAndFieldsExample) {
        assertEquals("var", varValue)
        varValue = "var1"
        assertEquals("var1", varValue)
        assertEquals("val", valValue)
//    propertiesAndFieldsExample.valValue = "new val" - won't work
        assertEquals("ABC", varGetterSetterValue)
        varGetterSetterValue = "Getter Setter"
        assertEquals("GETTER SETTER", varGetterSetterValue)
        assertEquals("private", varPrivateSetterValue)
//    propertiesAndFieldsExample.varPrivateSetterValue = "test" - won't work
        assertNull(lateInitVar)
        lateInitVar = "late init"
        assertEquals("late init", lateInitVar)
    }
}