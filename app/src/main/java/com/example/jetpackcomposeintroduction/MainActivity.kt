package com.example.jetpackcomposeintroduction

import android.inputmethodservice.Keyboard
import android.media.Image
import android.os.Bundle
import android.view.Surface
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                Column {
                    UserCard()
                    MainContent()
                }
            }
        }
    }
}

data class User(
    val id: Int
)

val users = listOf(User(1), User(1), User(1), User(1), User(1), User(1), User(1), User(1))

@Composable
fun MainContent() {
    val user = User(1)
    val users = remember {
        mutableStateListOf(user)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users = users)
        Button(modifier = Modifier
            .padding(24.dp)
            .align(Alignment.BottomCenter), onClick = {
            users.add(User(1))
        }) {
            Text(text = "Add More")
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn() {
        items((users)) { _ ->
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    val context = LocalContext.current

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.dummytext), maxLines = 4)
                Button(onClick = {
                    Toast.makeText(context, "View Profile Clicked", Toast.LENGTH_SHORT).show()
                }, Modifier.padding(top = 4.dp)) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        MainContent()
    }
}