package com.joaobzao.todoish.feature_todo.presentation

import com.joaobzao.todoish.feature_todo.data.entities.Todo
import com.joaobzao.todoish.feature_todo.domain.util.OrderType
import com.joaobzao.todoish.feature_todo.domain.util.TodoOrder

data class TodosViewState(
    val todos: List<Todo> = emptyList(),
    val todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending)
)