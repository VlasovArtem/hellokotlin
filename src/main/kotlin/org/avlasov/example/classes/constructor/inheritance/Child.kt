package org.avlasov.example.classes.constructor.inheritance

/**
 *   Created By artemvlasov on 2018-10-18
 **/
class Child(childName: String) : Parent(childName) {

    override val x: String = "child x"
    override var y: String = "child y"

    override fun info(): String = "Child"

    inner class InnerClass {
        fun innerFunction() {
            super@Child.info()
        }
    }

}