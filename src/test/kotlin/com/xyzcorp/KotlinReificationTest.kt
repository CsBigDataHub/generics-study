package com.xyzcorp

import org.junit.Test
import kotlin.test.assertEquals

class KotlinReificationTest {
    @Test
    fun testBox() {
        val list: List<Int> = listOf(4, 2, 1, 5)
        val result: String? = KotlinReification.whoAmI(list)
        assertEquals(result ?: "Nope", "kotlin.Int")
    }
}