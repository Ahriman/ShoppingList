package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

// https://stackoverflow.com/questions/70309293/each-instance-of-class-worker-should-have-an-own-id-starting-at-1-and-get-inc
//private val count: AtomicInteger = AtomicInteger(0)

class Product(
    val name: String,
    initialChecked: Boolean = false
) {
    // Se comparte en todas las instancias de la clase
    companion object {
        private val count: AtomicInteger = AtomicInteger(0)
    }

    val id: Int = count.incrementAndGet()
    var checked by mutableStateOf(initialChecked)
}