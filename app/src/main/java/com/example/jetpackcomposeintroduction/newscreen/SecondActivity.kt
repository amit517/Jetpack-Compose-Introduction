package com.example.jetpackcomposeintroduction.newscreen

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeintroduction.R
import com.example.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                profileCard()
            }
        }
    }
}

@Composable
@Preview(name = "Light mood")
@Preview(name = "Dark mode",
         uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun profileCard() {
    Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
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
                Text(text = "Amit Kundu", color = MaterialTheme.colors.secondaryVariant, modifier = Modifier.padding(4.dp))
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "amit517", style = MaterialTheme.typography.subtitle2)
        }
    }
}


