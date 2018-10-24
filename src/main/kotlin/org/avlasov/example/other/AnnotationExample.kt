package org.avlasov.example.other

import org.junit.Assert.*
import kotlin.reflect.KClass

/**
 *   Created By artemvlasov on 2018-10-24
 *   https://kotlinlang.org/docs/reference/annotations.html
 **/
annotation class InternalAnnotation(val string: String)

annotation class FieldAnnotation(val fieldAge: Int = 29)

annotation class Special(val name: String, val age: Int, val enum: AnnotationEnum, val charArray: CharArray, val internalAnnotation: InternalAnnotation, val kClass : KClass<*>)

enum class AnnotationEnum {
    FIRST, SECOND
}

class AnnotationExample {
    @Special("Special Name", 1, AnnotationEnum.SECOND, ['c', 'b'], InternalAnnotation("annotation"), String::class) class Foo(@field:FieldAnnotation(31) val constructorStr: String)
}

fun main(args: Array<String>) {
    val foo = AnnotationExample.Foo("test")
    var requiredAnnotationFound = false
    for (annotationData in foo::class.java.annotations) {
        if (annotationData is Special) {
            assertEquals("Special Name", annotationData.name)
            assertEquals(1, annotationData.age)
            assertEquals(AnnotationEnum.SECOND, annotationData.enum)
            assertArrayEquals(charArrayOf('c', 'b'), annotationData.charArray)
            assertEquals("annotation", annotationData.internalAnnotation.string)
            assertEquals(String::class, annotationData.kClass)
        }
    }
    val declaredField = foo::class.java.getDeclaredField("constructorStr")
    declaredField.annotations.forEach { annotation ->
        if (annotation is FieldAnnotation) {
            assertEquals(31, annotation.fieldAge)
            requiredAnnotationFound = true
        }
    }
    assertTrue(requiredAnnotationFound)
}