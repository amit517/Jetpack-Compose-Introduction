package com.example.jetpackcomposeintroduction.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeintroduction.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    title: String,
    titleSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleWeight: FontWeight = FontWeight.Bold,
    descriptionWeight: FontWeight = FontWeight.Normal,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    description: String,
    ) {
    var expendedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expendedState) 180f else 0f, label = "")

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
                animationSpec = tween(
                        durationMillis = 300, // Duration of the animation
                        easing = LinearOutSlowInEasing // easing style
                )
        ),
         shape = Shapes.medium,
         onClick = { expendedState= !expendedState }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Row (verticalAlignment = Alignment.CenterVertically,
                ){
                Text(text = title,
                     fontSize = titleSize,
                     fontWeight = titleWeight,
                     modifier = Modifier.weight(6f),
                     maxLines = 1,
                     overflow = TextOverflow.Ellipsis)
                IconButton(
                        onClick = { expendedState= !expendedState },
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                            .weight(1f)
                            .rotate(rotationState),
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Arrow-Drop-down")
                }
            }
            if (expendedState){
                Text(text = description,
                     maxLines = 4,
                     overflow = TextOverflow.Ellipsis,
                     fontWeight = descriptionWeight,
                     fontSize = descriptionFontSize)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpendableCardPreview() {
    ExpandableCard(title = "My title", description = "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\"")
}
