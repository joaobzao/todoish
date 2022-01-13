package com.joaobzao.todoish.di

import android.app.Application
import androidx.room.Room
import com.joaobzao.todoish.feature_todo.data.TodoDatabase
import com.joaobzao.todoish.feature_todo.data.repository.TodoRepositoryImpl
import com.joaobzao.todoish.feature_todo.domain.repositories.TodoRepository
import com.joaobzao.todoish.feature_todo.domain.usecase.DeleteTodo
import com.joaobzao.todoish.feature_todo.domain.usecase.GetTodos
import com.joaobzao.todoish.feature_todo.domain.usecase.InsertTodo
import com.joaobzao.todoish.feature_todo.domain.usecase.TodoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository =
        TodoRepositoryImpl(db.todoDao)

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository): TodoUseCases =
        TodoUseCases(
            getTodos = GetTodos(repository),
            insertTodo = InsertTodo(repository),
            deleteTodo = DeleteTodo(repository)
        )
}