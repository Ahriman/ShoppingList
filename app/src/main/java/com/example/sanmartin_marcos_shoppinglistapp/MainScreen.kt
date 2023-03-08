package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    Text(text = "Shopping List")
                }//, modifier = Modifier.height(100.dp)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

            ProductTasksList(
                list = productViewModel.tasks,
                onCheckedTask = { task, checked ->
                    productViewModel.changeTaskChecked(task, checked)
                },
                onCloseTask = { task ->
                    productViewModel.remove(task)
                }, modifier = modifier
            )

        }
    }





}
