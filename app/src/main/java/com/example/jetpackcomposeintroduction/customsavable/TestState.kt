package com.example.jetpackcomposeintroduction.customsavable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.seconds

class TestState(
    initialTime: Long,
    val scope: CoroutineScope

) {
    var elapsedTime by mutableLongStateOf(initialTime)
    private var isIncrement : Boolean = false
    suspend fun startIncrement() {
        isIncrement = true
        while (isIncrement){
            elapsedTime += measureTimeMillis {
                delay(1.seconds / 30)
            }
        }
    }

    fun resetTime() {
        scope.launch {
            isIncrement = false
            delay(300)
            elapsedTime = 0L
        }
    }

    companion object {
        private const val ELAPSED_TIME_KEY = "elapsed_time"

       fun saver(scope: CoroutineScope) = Saver<TestState, Map<String, Any>>(
            save = { state ->
                mapOf(
                    ELAPSED_TIME_KEY to state.elapsedTime,
                )
            },
            restore = { savedValue ->
                TestState(
                    savedValue[ELAPSED_TIME_KEY] as Long,
                    scope
                )
            }
        )
    }
}

@Composable
fun rememberTestState(
    initialTime: Long,
    scope: CoroutineScope = rememberCoroutineScope(),
): TestState {
    return rememberSaveable(
            saver = TestState.saver(scope)
    ) {
        TestState(initialTime, scope)
    }
}

