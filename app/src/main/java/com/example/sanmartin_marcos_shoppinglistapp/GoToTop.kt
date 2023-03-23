package com.example.sanmartin_marcos_shoppinglistapp


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GoToTop(goToTop: () -> Unit, visible: Boolean) {

    AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {

        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .size(50.dp),
            onClick = goToTop,
            backgroundColor = White,
            contentColor = Black
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                contentDescription = "go to top"
            )
        }

    }

}