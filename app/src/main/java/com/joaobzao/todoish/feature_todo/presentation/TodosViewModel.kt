package com.joaobzao.todoish.feature_todo.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaobzao.todoish.feature_todo.domain.interactors.DeleteTodo
import com.joaobzao.todoish.feature_todo.domain.interactors.GetTodos
import com.joaobzao.todoish.feature_todo.domain.util.OrderType
import com.joaobzao.todoish.feature_todo.domain.util.TodoOrder
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TodosViewModel(
    private val getTodos: GetTodos,
    private val deleteTodo: DeleteTodo
): ViewModel() {
    private val _state = mutableStateOf(TodosViewState())
    private var getTodosJob: Job? = null

    val state: State<TodosViewState> = _state

    init {
        getTodos(TodoOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: TodosEvent) {
        when(event) {
            is TodosEvent.Order -> {
                if (state.value.todoOrder::class == event.todoOrder::class &&
                    state.value.todoOrder.orderType == event.todoOrder.orderType) {
                    return
                }
                getTodos(event.todoOrder)
            }

            is TodosEvent.DeleteTodo -> {
                viewModelScope.launch {
                    deleteTodo(event.todo)
                }
            }
        }
    }

    private fun getTodos(todoOrder: TodoOrder) {
        getTodosJob?.cancel()
        getTodosJob = getTodos()
            .onEach { todos ->
                _state.value = state.value.copy(
                    todos = todos,
                    todoOrder = todoOrder
                )
            }
            .launchIn(viewModelScope)
    }
}