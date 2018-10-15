package org.avlasov.classes

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class Rectangle(var height: Double, var length: Double) : Shape(listOf(height, length, height, length)),  RectangleProperties {

    override val isSquare: Boolean get() = length == height
    override fun calculateArea(): Double = height * length

}