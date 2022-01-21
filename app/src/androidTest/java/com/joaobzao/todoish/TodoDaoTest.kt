package com.joaobzao.todoish

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.joaobzao.todoish.todo.data.TodoDatabase
import com.joaobzao.todoish.todo.data.daos.TodoDao
import com.joaobzao.todoish.todo.data.entities.Todo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.nullValue
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class TodoDaoTest: DatabaseTest() {

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

    @Test
    @Throws(Exception::class)
    fun deleteTodoInDb() = testScope.runBlockingTest {
        // Given
        val todo = Todo(
            id = 1L,
            title = "test todo",
            timestamp = 5L
        )

        todoDao.insertTodo(todo)

        // When
        todoDao.deleteTodo(todo)

        // Then
        assertThat(todoDao.getTodoById(todo.id), nullValue())
    }

    @Test
    @Throws(Exception::class)
    fun getTodosInDb() = testScope.runBlockingTest {
        // Given
        repeat(2) {
            todoDao.insertTodo(
                Todo(
                    id = it.inc().toLong(),
                    title = "test todo",
                    timestamp = 5L
                )
            )
        }

        // When
        val todos = todoDao.getTodos()

        // Then
        todos.take(2).onEach {
            assertThat(it.first(), equalTo(1))
            assertThat(it.last(), equalTo(2))
        }
    }

    @After
    fun cleanup() {
        testScope.cleanupTestCoroutines()
    }
}