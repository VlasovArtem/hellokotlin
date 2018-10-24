package org.avlasov.example.other

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

/**
 *   Created By artemvlasov on 2018-10-23
 *   https://kotlinlang.org/docs/reference/operator-overloading.html
 **/
class ErrorClass

class OperatorClass {

    var count = 0

    operator fun unaryPlus() = count++
    operator fun unaryMinus() = if (count == 0) 0 else count--
    operator fun not() = count == 0
    operator fun inc() : OperatorClass {
        this.count++
        return this
    }
    operator fun dec() : OperatorClass {
        this.count--
        return this
    }
    operator fun plus(increment: Int): OperatorClass {
        this.count += increment
        return this
    }
    operator fun contains(inInt: Int) : Boolean = count == inInt
    operator fun get(value: Int) : Boolean = count == value
    operator fun set(index: Int, value2: Int) {
        count = value2
    }

}

data class IntExample(var x: Int, var y: Int)

operator fun IntExample.unaryMinus() {
    --x
    --y
}

fun verifyOverloadingClassOperators() {
    var operatorClass = OperatorClass()
    Assert.assertTrue(!operatorClass)
    verifyUnaryOperators(operatorClass, 0) {}
    verifyUnaryOperators(operatorClass, 0) { -operatorClass }
    verifyUnaryOperators(operatorClass, 1) { +operatorClass }
    Assert.assertFalse(!operatorClass)
    verifyUnaryOperators(operatorClass, 0) { -operatorClass }
    verifyUnaryOperators(operatorClass, 1) { ++operatorClass }
    verifyUnaryOperators(operatorClass, 2) { ++operatorClass }
    verifyUnaryOperators(operatorClass, 1) { --operatorClass }
    verifyUnaryOperators(operatorClass, 10) { operatorClass + 9  }
    assertTrue(10 in operatorClass)
    verifyUnaryOperators(operatorClass, 5) { operatorClass[5] = 5  }
    assertTrue(operatorClass[5])
//    -ErrorClass() - compile error
}

fun verifyFunExtensionOperator() {
    val intExample = IntExample(10, 3)
    intExample.unaryMinus()
    assertEquals(9, intExample.x)
    assertEquals(2, intExample.y)
    -intExample
    assertEquals(8, intExample.x)
    assertEquals(1, intExample.y)
}

fun verifyUnaryOperators(operatorClass: OperatorClass, expected: Int, operation: (OperatorClass) -> Unit) {
    operation.invoke(operatorClass)
    assertEquals(expected, operatorClass.count)
}

fun main(args: Array<String>) {
    verifyOverloadingClassOperators()
    verifyFunExtensionOperator()
}