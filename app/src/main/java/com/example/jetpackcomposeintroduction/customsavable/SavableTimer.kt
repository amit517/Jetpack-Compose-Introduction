package com.example.jetpackcomposeintroduction.customsavable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun SavableTimer() {

    val scope = rememberCoroutineScope()

    val testState: TestState = rememberTestState(100)


    Column(modifier = Modifier,
           horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = testState.elapsedTime.toString())

        Button(onClick = { scope.launch {
            testState.startIncrement()
        } }) {
            Text(text = "Start Timer")
        }
        Button(onClick = {
            testState.resetTime()
        }) {
            Text(text = "Reset")
        }
    }
}
