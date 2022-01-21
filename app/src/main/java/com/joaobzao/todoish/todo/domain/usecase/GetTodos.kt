package com.joaobzao.todoish.todo.domain.usecase

import com.joaobzao.todoish.todo.data.entities.Todo
import com.joaobzao.todoish.todo.domain.repositories.TodoRepository
import com.joaobzao.todoish.todo.domain.util.OrderType
import com.joaobzao.todoish.todo.domain.util.TodoOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodos(
    private val repository: TodoRepository
) {

    operator fun invoke(
        todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending)
    ): Flow<List<Todo>> {
        return repository.getTodos()
            .map { todos ->
                when(todoOrder.orderType) {
                    is OrderType.Ascending -> {
                        when(todoOrder) {
                            is TodoOrder.Title -> todos.sortedBy { it.title.lowercase() }
                            is TodoOrder.Date -> todos.sortedBy { it.timestamp }
                        }
                    }
                    is OrderType.Descending -> {
                        when(todoOrder) {
                            is TodoOrder.Title -> todos.sortedByDescending { it.title.lowercase() }
                            is TodoOrder.Date -> todos.sortedByDescending { it.timestamp }
                        }
                    }
                }
            }
    }
}