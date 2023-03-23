package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
//    productViewModel: ProductViewModel = viewModel(),
) {

    val productViewModel: ProductViewModel = viewModel()

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showGoToTopButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
                    // De esta forma sirve para cualquier pantalla, al no meter un valor a mano para un dispositivo/tamaño
                    && (listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size <
                    listState.layoutInfo.totalItemsCount)
//                    || listState.isScrollInProgress
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        },
        floatingActionButton = {
            GoToTop(
                goToTop = {
                    scope.launch {
                        listState.scrollToItem(0)
                    }
                },
                visible = showGoToTopButton,
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->

        Column(modifier = modifier.padding(paddingValues = paddingValues)) {

            ProductList(
                list = productViewModel.products,
                onChecked = { product, checked ->
                    productViewModel.changeChecked(product, checked)
                },
                onClose = { product ->
                    productViewModel.remove(product)
                },
                listState = listState
            )

        }

    }

}
