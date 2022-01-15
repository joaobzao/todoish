package com.joaobzao.todoish.feature_todo.presentation

import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoScreen(
    viewModel: TodosViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    TodoScaffold()
}

@Composable
fun TodoScaffold() {
    Text("Hello Todo Screen!")
}

@Preview(showBackground = true)
@Composable
fun TodoScreen_Preview() {
    TodoScaffold()
}