package org.avlasov.classes.order

/**
 *   Created By artemvlasov on 2018-10-18
 **/
open class First(name: String) {

    init {
        println("First init")
    }

    open val size: Int = name.length.also { println("First size $it") }

}

class Second(name: String, lastName: String) : First(name.capitalize().also { println("Second argument $it") }) {

    init {
        println("Second init")
    }

    override val size: Int = (super.size + lastName.length).also { println("Second size $it") }

}

fun main(args: Array<String>) {
    val second = Second("name", "lastName")
}