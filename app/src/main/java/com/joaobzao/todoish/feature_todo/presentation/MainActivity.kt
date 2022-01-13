package com.joaobzao.todoish.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.joaobzao.todoish.feature_todo.data.TodoDatabase
import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.data.entities.TodoEntity
import com.joaobzao.todoish.feature_todo.data.repository.TodoRepositoryImpl
import com.joaobzao.todoish.feature_todo.domain.interactors.DeleteTodo
import com.joaobzao.todoish.feature_todo.domain.interactors.GetTodos
import com.joaobzao.todoish.feature_todo.domain.interactors.InsertTodo
import com.joaobzao.todoish.ui.theme.TodoishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: This is just for testing, going to move this out of here
        val db = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            "todo-database"
        ).build()

        val repository = TodoRepositoryImpl(db.todoDao)

        val todosViewModel = TodosViewModel(
            GetTodos(repository),
            DeleteTodo(repository),
            InsertTodo(repository)
        )

        val todo = Todo(title = "foo", timestamp = 1L)

        todosViewModel.onEvent(TodosEvent.InsertTodo(todo))

        setContent {
            TodoishTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoishTheme {
        Greeting("Android")
    }
}