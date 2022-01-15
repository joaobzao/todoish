package com.joaobzao.todoish

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.joaobzao.todoish.feature_todo.data.TodoDatabase
import com.joaobzao.todoish.feature_todo.data.daos.TodoDao
import com.joaobzao.todoish.feature_todo.data.entities.Todo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.nullValue
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class TodoDaoTest : DatabaseTest() {

    private lateinit var todoDao: TodoDao
    private lateinit var todoDatabase: TodoDatabase

    @Before
    fun initDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        todoDatabase = Room
            .inMemoryDatabaseBuilder(context, TodoDatabase::class.java)
            .setTransactionExecutor(testDispatcher.asExecutor())
            .setQueryExecutor(testDispatcher.asExecutor())
            .build()

        todoDao = todoDatabase.todoDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        todoDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertTodoInDb() = testScope.runBlockingTest {
        // Given
        val todo = Todo(
            id = 1L,
            title = "test todo",
            timestamp = 5L
        )

        // When
        todoDao.insertTodo(todo)

        // Then
        assertThat(todoDao.getTodoById(todo.id), equalTo(todo))
    }

    @Test
    @Throws(Exception::class)
    fun dbIsEmpty() = testScope.runBlockingTest {
        // Given
        // When
        val todos = todoDao.getTodos()

        // Then
        assertThat(todos.firstOrNull(), equalTo(emptyList()))
    }

    @After
    fun cleanup() {
        testScope.cleanupTestCoroutines()
    }
}