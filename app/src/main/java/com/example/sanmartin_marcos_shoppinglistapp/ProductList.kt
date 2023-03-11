package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductList(
    list: List<Product>,
    onChecked: (Product, Boolean) -> Unit,
    onClose: (Product) -> Unit,
    onAddProduct: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    ProductAdd(
        onAddProduct = { name ->
            onAddProduct(name)
        })

    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { product -> product.id }
        ) { product ->

            ProductItem(
                productName = product.id.toString() + ' ' + product.name,
                checked = product.checked,
                onCheckedChange = { checked -> onChecked(product, checked) },
                onClose = { onClose(product) }
            )
        }
    }
}