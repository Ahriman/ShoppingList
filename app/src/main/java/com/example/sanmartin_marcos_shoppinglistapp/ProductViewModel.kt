package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _products = mutableStateListOf<Product>()
    val products: List<Product>
        get() = _products

    fun remove(item: Product) {
        _products.remove(item)
    }

    fun changeChecked(item: Product, checked: Boolean) {
        item.checked = checked
    }
//        products.find { it.id == item.id }?.let { product ->
//            product.checked = checked
//        }


    fun add(name: String){
        if (name.isNotBlank())
            _products.add(Product(name))
    }

}

