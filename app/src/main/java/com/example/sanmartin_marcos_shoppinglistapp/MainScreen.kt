package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    productViewModel: ProductViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) { paddingValues ->

        Column(modifier = modifier.padding(paddingValues = paddingValues)) {

//            ProductAdd(onAddProduct = {
//                productViewModel.add(it)
//            })

            ProductList(
                list = productViewModel.products,
                onChecked = { product, checked ->
                    productViewModel.changeChecked(product, checked)
                },
                onClose = { product ->
                    productViewModel.remove(product)
                },
            )

        }

    }

}
