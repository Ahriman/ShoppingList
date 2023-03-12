package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

@OptIn(ExperimentalFoundationApi::class)
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
                productName = product.name, // "${product.id} ${product.name}"
                checked = product.checked,
                onCheckedChange = { checked -> onChecked(product, checked) },
                onClose = { onClose(product) },
                modifier = Modifier.animateItemPlacement()
                    .clickable{
                        onChecked(product, !product.checked)
                    }
                    .pointerInput(Unit){
                        detectDragGesturesAfterLongPress { change, dragAmount ->
                            if (dragAmount.x < -15) {
                                onClose(product)
                            }
                        }
                    }

            )
        }
    }
}