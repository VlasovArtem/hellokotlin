package org.avlasov.classes.inheritance

/**
 *   Created By artemvlasov on 2018-10-12
 **/
class App

fun main(arg: Array<String>) {
    val triangle = Triangle(5.0, 5.0, 5.0)
    assert(triangle.perimeter == 8.6)
    val rectangle = Rectangle(20.0, 20.0)
    val calculateRectangleArea = rectangle.calculateArea()
    assert(calculateRectangleArea == 400.0)
    assert(rectangle.isSquare)
    println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
    println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
}
