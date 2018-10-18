package org.avlasov.classes.constructor.inheritance

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class Child(childName: String) : Parent(childName) {

    override fun info(): String = "Child"

}