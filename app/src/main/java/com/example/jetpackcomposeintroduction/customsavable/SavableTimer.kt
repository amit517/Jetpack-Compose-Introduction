package com.example.jetpackcomposeintroduction.customsavable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeintroduction.LocalUser
import com.example.jetpackcomposeintroduction.StaticLocalUser
import kotlinx.coroutines.launch

@Composable
fun SavableTimer() {

    val scope = rememberCoroutineScope()

    val testState: TestState = rememberTestState(100)
    val currentUser = LocalUser.current
    val staticUser = StaticLocalUser.current

    Column(modifier = Modifier,
           horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Local user $currentUser")

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
