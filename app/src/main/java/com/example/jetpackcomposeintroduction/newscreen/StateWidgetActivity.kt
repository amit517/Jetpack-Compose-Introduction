package com.example.jetpackcomposeintroduction.newscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeintroduction.newscreen.ui.theme.JetpackComposeIntroductionTheme

class StateWidgetActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    StateFullWidget()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun StateFullWidget() {
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.fillMaxSize().wrapContentSize() ) {
        TextField(value = name,
                  onValueChange = { name = it },
                  label = { Text(text = "Greetings") })

        Button(onClick = { Toast.makeText(context, "$name", Toast.LENGTH_SHORT).show() },
               modifier = Modifier
                   .fillMaxWidth()
                   .wrapContentSize()
                   .padding(top = 16.dp),
               colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
            Text(text = "Greet me")
        }
    }
}
