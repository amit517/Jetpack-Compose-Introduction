package com.example.jetpackcomposeintroduction.newscreen2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeintroduction.theme.JetpackComposeIntroductionTheme

class NewScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                Surface() {
                    CountGenerator()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun CountGenerator() {
        var count by remember {
            mutableStateOf(0)
        }
        Column(modifier = Modifier.fillMaxSize().background(Color.LightGray),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(color = Color.Black, text = count.toString())
            Button(
                    onClick = { count++ }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Add Count",modifier = Modifier.padding(20.dp,8.dp), fontSize = 20.sp)
            }
        }
    }
}
