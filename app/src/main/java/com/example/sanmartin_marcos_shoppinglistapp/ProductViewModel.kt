package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class ProductViewModel : ViewModel() {
    private val _tasks = getProducts().toMutableStateList()
    val tasks: List<ProductTask>
        get() = _tasks

    fun remove(item: ProductTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: ProductTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

}

private fun getProducts() = List(30) { i -> ProductTask(i, "Producto $i") }
