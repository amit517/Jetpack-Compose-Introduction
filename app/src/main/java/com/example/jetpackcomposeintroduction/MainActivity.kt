package com.example.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "Amit Kundu")
        }
    }
}

@Composable
fun Greeting(name: String) =
    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Text(text = "Hello $name!")
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeIntroductionTheme {
        Greeting("Amit Kundu")
    }
}