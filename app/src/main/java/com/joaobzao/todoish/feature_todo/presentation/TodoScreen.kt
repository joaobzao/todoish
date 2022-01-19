package com.joaobzao.todoish.feature_todo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
        bottomBar = {
            Column {
                TodoBottomAppBar()
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colors.primary
                        )
                )
            }
        }
    ) {

    }
}

@Composable
private fun TodoBottomAppBar() {
    BottomAppBar(
        cutoutShape = RoundedCornerShape(50),
        backgroundColor = MaterialTheme.colors.primary,
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