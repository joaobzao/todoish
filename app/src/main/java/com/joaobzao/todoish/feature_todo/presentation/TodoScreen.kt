package com.joaobzao.todoish.feature_todo.presentation

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoScreen(
    viewModel: TodosViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    TodoScaffold()
}

@Composable
fun TodoScaffold() {
    //val scaffoldState = rememberScaffoldState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Todo"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = { TodoBottomAppBar() }
    ) {

    }
}

@Composable
private fun TodoBottomAppBar() {
    BottomAppBar(
        Modifier.offset(Dp.Hairline),
        cutoutShape = RoundedCornerShape(100),
    ) {
        Button(
            onClick = { /*TODO*/ },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreen_Preview() {
    TodoScaffold()
}