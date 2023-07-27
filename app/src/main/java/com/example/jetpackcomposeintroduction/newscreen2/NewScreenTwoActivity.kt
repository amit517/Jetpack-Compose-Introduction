package com.example.jetpackcomposeintroduction.newscreen2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.graphics.RectangleShape
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
                    RowWithSurface()
                }
            }
        }
    }

    //    @Preview(showSystemUi = true)
    @Composable
    fun CountGenerator() {
        var count by remember {
            mutableStateOf(0)
        }
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(color = Color.Black, text = count.toString())
            Button(
                    onClick = { count++ }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Add Count", modifier = Modifier.padding(20.dp, 8.dp), fontSize = 20.sp)
            }
        }
    }

    //    @Preview(showSystemUi = true, name = "ExampleColumn")
    @Composable
    fun ExampleColumn() {
        // Column will add all of it's children in Vertical stack
        Column {
            Text(text = "1st Text")
            Text(text = "2nd Text")
        }
    }

    //    @Preview(showSystemUi = true, name = "ExampleRow")
    @Composable
    fun ExampleRow() {
        // Row will add all of it's children in Horizontal stack
        Row {
            Text(text = "1st Text")
            Text(text = "2nd Text")
        }
    }

    //    @Preview(showSystemUi = true)
    @Composable
    fun RowAndColumn() {
        Column {
            Row(modifier = Modifier
                .border(2.dp, color = Color.Black, RectangleShape)
                .padding(8.dp)) {
                Text(text = "Row 1, Column 1")
                Spacer(modifier = Modifier.width(8.dp))
                Divider(color = Color.Black, thickness = 4.dp, modifier = Modifier
                    .width(2.dp)
                    .height(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Row 1, Column 2")
            }
            Row {
                Text(text = "Row 2, Column 1")
                Text(text = "Row 2, Column 2")
            }
        }
    }

    @Composable
    fun ColumnScope.CustomField(weight : Float, color: Color = Color.Cyan) {
        Surface(
                modifier = Modifier
                    .width(200.dp)
                    .weight(weight),
                color = color,
        ) {}
    }

    @Preview(showSystemUi = true)
    @Composable
    fun ColumnWithSurface() {
        Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .height(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
        ) {
            CustomField(weight = 3f, color = Color.Blue)
            CustomField(weight = 2f)
        }
    }

    @Composable
    fun RowScope.CustomField(weight : Float, color: Color = Color.Cyan) {
        Surface(
                modifier = Modifier
                    .height(60.dp)
                    .weight(weight),
                color = color,
        ) {}
    }

    @Preview(showSystemUi = true)
    @Composable
    fun RowWithSurface() {
        Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .padding(end = 16.dp, start = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
        ) {
            CustomField(weight = 3f, color = Color.Blue)
            CustomField(weight = 3f)
        }
    }
}
