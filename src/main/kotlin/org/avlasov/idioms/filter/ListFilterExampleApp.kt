package org.avlasov.idioms.filter

import org.hamcrest.collection.IsCollectionWithSize
import org.hamcrest.core.IsCollectionContaining
import org.junit.Assert.assertThat

/**
 *   Created By artemvlasov on 2018-10-16
 **/
fun main(args: Array<String>) {
    val integers = listOf(0, 10, 5, -10, 3, -5)
    val positive = integers.filter { x -> x >= 0 }
    val negative = integers.filter { it < 0 }
    assertThat(positive, IsCollectionWithSize.hasSize(4))
    assertThat(positive, IsCollectionContaining.hasItems(0, 10, 5, 3))
    assertThat(negative, IsCollectionWithSize.hasSize(2))
    assertThat(negative, IsCollectionContaining.hasItems(-10, -5))
}