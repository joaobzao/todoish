package com.joaobzao.todoish.feature_todo.presentation

import androidx.lifecycle.ViewModel
import com.joaobzao.todoish.feature_todo.domain.interactors.DeleteTodo
import com.joaobzao.todoish.feature_todo.domain.interactors.GetTodos

class TodosViewModel(
    private val getTodos: GetTodos,
    private val deleteTodo: DeleteTodo
): ViewModel() {

}