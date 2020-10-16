package org.avlasov.example.collection

import org.hamcrest.collection.IsCollectionWithSize
import org.hamcrest.collection.IsEmptyCollection
import org.junit.Assert.*
import java.util.*

/**
 *   Created By artemvlasov on 2018-10-15
 **/
class CollectionsExampleApp {

    fun joinCollection(list: List<String>, delimiter: String): String {
        val stringJoiner = StringJoiner(delimiter)
        for (item in list) {
            stringJoiner.add(item)
        }
        return stringJoiner.toString()
    }

    fun whenCollectionExists(list: List<String>): Boolean {
        return when {
            "apple" in list -> true
            "orange" in list -> true
            else -> false
        }
    }

    fun filterToUpperCaseData(list: List<String>, firstLetter: Char): List<String> {
        return list
            .filter { it.startsWith(firstLetter, true) }
            .map { it.toUpperCase() }
            .toCollection(arrayListOf())
    }

    fun getListValue(list: List<String>): String? {
        return list.firstOrNull()
    }

}

fun verifyCovariant() {
    abstract class Shape
    class Rectangle : Shape()
    class Circle : Shape()

    val listOf = listOf(Rectangle(), Rectangle())

    val listOfShapes: List<Shape> = listOf
    val mutableListOf = mutableListOf(Rectangle(), Rectangle())

    mutableListOf.add(0, Rectangle())
    mutableListOf[0] = Rectangle()


//    val listOfMutableShapes: MutableList<Shape> = mutableListOf - won't compile
    val listOfShapesFromMutable: List<Shape> = mutableListOf.toList() // will return copy of a mutable list
}

fun main(args: Array<String>) {
    val collectionsExampleApp = CollectionsExampleApp()
    val data = listOf("apple", "orange", "avocado", "banana")
    val joinCollection = collectionsExampleApp.joinCollection(data, ":")
    assertEquals("apple:orange:avocado:banana", joinCollection)
    assertTrue(collectionsExampleApp.whenCollectionExists(data))
    assertFalse(collectionsExampleApp.whenCollectionExists(listOf("test1", "test2", "test3")))
    val filterToUpperCaseData = collectionsExampleApp.filterToUpperCaseData(data, 'a')
    assertThat(filterToUpperCaseData, IsCollectionWithSize.hasSize(2))
    assertTrue(filterToUpperCaseData.contains("APPLE"))
    val filterToUpperCaseData1 = collectionsExampleApp.filterToUpperCaseData(data, 'c')
    assertThat(filterToUpperCaseData1, IsEmptyCollection.empty())
    assertEquals("test", collectionsExampleApp.getListValue(listOf("test", "test1")))
    assertNull(collectionsExampleApp.getListValue(emptyList()))
    verifyCovariant()
}