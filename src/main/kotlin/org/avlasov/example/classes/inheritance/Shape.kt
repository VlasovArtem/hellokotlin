package org.avlasov.example.classes.inheritance

/**
 *   Created By artemvlasov on 2018-10-12
 **/
abstract class Shape(val sides: List<Double>) {

    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double

}