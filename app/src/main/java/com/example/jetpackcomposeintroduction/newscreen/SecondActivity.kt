package com.example.jetpackcomposeintroduction.newscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeintroduction.R
import com.example.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme
import com.example.jetpackcomposeintroduction.ui.theme.Typography

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                MyDisplay()
            }
        }
    }
}

@Composable
@Preview(name = "Light mood", showSystemUi = true)
//@Preview(name = "Dark mode",
//         uiMode = Configuration.UI_MODE_NIGHT_YES
//)
fun MyDisplay() {
    Column() {
        Greetings()
        profileCard("Amit Kundu")
    }
}

@Composable
fun Greetings(nameList: List<String> = listOf("amit", "sourav")) {
    nameList.forEachIndexed { index, it -> GreetingsCard(name = it, if (index == 0) 8 else 4) }
}

@Composable
fun GreetingsCard(name: String, topPadding: Int) {
    Spacer(modifier = Modifier.width(4.dp))
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(start = 8.dp, top = topPadding.dp, end = 8.dp, bottom = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello")
                Text(text = name)
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Send Message")
            }
        }
    }
}

@Composable
fun profileCard(name : String) {
    Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.my_image), contentDescription = null, modifier = Modifier
            // Set image size to 40 dp
            .size(40.dp)
            // Clip image to be shaped as a circle
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)

        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(fontStyle = FontStyle.Italic, text = name, style = Typography.h3, color = MaterialTheme.colors.secondaryVariant, modifier = Modifier.padding(4.dp))
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(modifier = Modifier.padding(start = 2.dp),text = "amit517", style = MaterialTheme.typography.subtitle2)
        }
    }
}


