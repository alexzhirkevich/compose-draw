package com.example.common

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round

@Composable
fun App() {

    var offset by remember {
        mutableStateOf(Offset.Zero)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTransformGestures { _, pan, _, _ ->
                offset += pan
            }
        }
    ){
        Box(modifier = Modifier
            .size(50.dp)
            .offset {
                offset.round()
            }
            .drawBehind {
                drawRect(
                    Color.Red,
                    Offset(-size.width*2.5f, -size.height*2.5f),
                    size * 5f,
                )
            }
            .background(Color.Green)
        )
    }
}
