package com.example.sanmartin_marcos_shoppinglistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

@Composable
fun ProductAdd (
    onAddProduct: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.padding(vertical = 16.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var productName by rememberSaveable { mutableStateOf("") }

        TextField(
            value = productName.replaceFirstChar { it.uppercase() },
            onValueChange = { productName = it },
            modifier = modifier.weight(0.8f),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            singleLine = true,
        )
        Spacer(modifier = modifier.padding(5.dp))
        Button(onClick = {
            onAddProduct(productName)
            productName = ""
        }) {
            Text(text = stringResource(id = R.string.add_button))
        }
    }
}