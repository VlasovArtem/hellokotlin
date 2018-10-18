package org.avlasov.classes.constructor.inheritance

/**
 *   Created By artemvlasov on 2018-10-18
 **/
open class Parent(var name: String) : Something{

    open val x: String = "parent x"
    override val y: String = "parent y"

    open fun info() : String = "Parent"

}