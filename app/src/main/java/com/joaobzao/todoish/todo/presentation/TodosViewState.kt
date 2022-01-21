package com.joaobzao.todoish.todo.presentation

import com.joaobzao.todoish.todo.data.entities.Todo
import com.joaobzao.todoish.todo.domain.util.OrderType
import com.joaobzao.todoish.todo.domain.util.TodoOrder

data class TodosViewState(
    val todos: List<Todo> = emptyList(),
    val todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending)
)