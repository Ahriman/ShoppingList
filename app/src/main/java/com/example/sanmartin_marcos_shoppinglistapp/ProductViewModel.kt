package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _products = listOf<Product>().toMutableStateList()
    val products: List<Product>
        get() = _products

    fun remove(item: Product) {
        _products.remove(item)
    }

    fun changeChecked(item: Product, checked: Boolean) =
        products.find { it.id == item.id }?.let { product ->
            product.checked = checked
        }

    fun addProduct(name: String){
        if (name.isNotEmpty())
            _products.add(Product(name))
    }

}

