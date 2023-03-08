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
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            ProductItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onChecked(task, checked) },
                onClose = { onClose(task) }
            )
        }
    }
}