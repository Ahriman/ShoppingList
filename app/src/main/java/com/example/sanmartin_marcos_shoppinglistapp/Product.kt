package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

private val count: AtomicInteger = AtomicInteger(0)

class Product(
    val name: String,
    initialChecked: Boolean = false
) {
    val id: Int = count.incrementAndGet()
    var checked by mutableStateOf(initialChecked)
}