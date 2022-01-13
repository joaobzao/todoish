package com.joaobzao.todoish.feature_todo.presentation

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.domain.util.TodoOrder

sealed class TodosEvent {
    data class Order(val todoOrder: TodoOrder): TodosEvent()
    data class DeleteTodo(val todo: Todo): TodosEvent()
    data class InsertTodo(val todo: Todo): TodosEvent()
}
