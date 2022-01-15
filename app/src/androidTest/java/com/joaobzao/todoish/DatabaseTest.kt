package com.joaobzao.todoish

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class DatabaseTest {

    @ExperimentalCoroutinesApi
    protected val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    protected val testScope = TestCoroutineScope(testDispatcher)
}