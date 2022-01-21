package com.joaobzao.todoish.todo.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.navigationBarsHeight
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun TodoScreen(
    viewModel: TodosViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    TodoScaffold()
}

@ExperimentalMaterialApi
@Composable
fun TodoScaffold() {
    val coroutineScope = rememberCoroutineScope()
    val rememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        if (rememberBottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            rememberBottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            rememberBottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
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
            }
        }
    ) {
        Column {
            AddTodo(rememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState)
        }
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

@ExperimentalMaterialApi
@Composable
private fun AddTodo(rememberBottomSheetScaffoldState: BottomSheetScaffoldState) {
    BottomSheetScaffold(
        scaffoldState = rememberBottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "We are going to insert todos from here.")
            }
        }, sheetPeekHeight = 0.dp
    ) { }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun TodoScreen_Preview() {
    TodoScaffold()
}