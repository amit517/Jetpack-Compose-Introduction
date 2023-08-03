package com.example.jetpackcomposeintroduction.newscreen2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.withStyledAttributes
import com.example.jetpackcomposeintroduction.R
import com.example.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme
import java.nio.file.WatchEvent

class NewScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopCenter) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        SuperScriptText("Hello", "world")
                    }
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
    fun ColumnScope.CustomField(weight: Float, color: Color = Color.Cyan) {
        Surface(
                modifier = Modifier
                    .width(200.dp)
                    .weight(weight),
                color = color,
        ) {}
    }

    /**
     * [Arrangement] Arrangement is something it tell how to draw component (Space, margin etc) will be there. it can have different aspect arrangement.
     * For Column As the component are stacked from top to bottom if we apply arrangement it will apply vertically for the column
     * For Row as the component is stacked from left to right if will apply in left to right that means horizontally.
     */

    /**
     * [Alignment] will be on the same direction as the component stacked
     * For column horizontally (Top, bottom)
     * For row vertically (Start, end)
     */

    //    @Preview(showSystemUi = true)
    @Composable
    fun ColumnWithSurface() {
        Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .height(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom //
        ) {
            CustomField(weight = 3f, color = Color.Blue)
            CustomField(weight = 2f)
        }
    }

    @Composable
    fun RowScope.CustomField(weight: Float, color: Color = Color.Cyan) {
        Surface(
                modifier = Modifier
                    .height(60.dp)
                    .weight(weight),
                color = color,
        ) {}
    }

    //    @Preview(showSystemUi = true)
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

    // Box composable are like the frame layout. We can use them when we want to place some component on top of other component.
    // It has certain alignment by using them we can arrange the positioning of the child component
    @Preview(showSystemUi = true)
    @Composable
    fun BoxComposable() {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center) {
                Box(modifier = Modifier
                    .background(Color.Green)
                    .wrapContentSize(),
                    contentAlignment = Alignment.TopCenter) {
                    Text(text = "Love Inside", fontSize = 40.sp)
                }
                Text(text = "I love android", fontSize = 40.sp)
            }
        }
    }

    // Text Customization
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun CustomizedText() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = stringResource(id = R.string.app_name),
                 modifier = Modifier
                     .width(350.dp)
                     .background(Color.Blue)
                     .padding(16.dp),
                 color = Color.White,
                 fontSize = MaterialTheme.typography.h6.fontSize,
                 fontStyle = FontStyle.Italic,
                 fontWeight = FontWeight.SemiBold,
                 textAlign = TextAlign.Center
            )
        }
    }

    // Text Customization
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun AnnotatedText() {
        Text(
                buildAnnotatedString {
                    withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                        withStyle(
                                style = SpanStyle(
                                        color = Color.Blue,
                                        fontSize = 30.sp
                                )

                        ) {
                            append("A")
                        }
                        append("B")
                        append("C")
                        append("D")
                        append("E")
                    }

                }, modifier = Modifier.width(200.dp)
        )
    }

    // Text Customization
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun CustomizedText3() {
        Text(text = "Hello world".repeat(20),
             maxLines = 2,
             overflow = TextOverflow.Ellipsis)
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun CustomSelectableText() {
        SelectionContainer {
            // Inside this scope all the text will be selectable
            Column {
                Text(text = "Hello world 1")
                Text(text = "Hello world 2")
                DisableSelection {
                    // If we want to make any text not selectable then we can use this composable
                    Text(text = "Hello world 3")
                }
                Text(text = "Hello world 4")
            }
        }
    }

    @Composable
    fun SuperScriptText(
        normalText: String,
        superText: String,
        normalFont: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
        superTextStyle : TextUnit = MaterialTheme.typography.overline.fontSize) {
        Text(
                buildAnnotatedString {
                    withStyle(
                            style = SpanStyle(fontSize = normalFont)

                    ) {
                        append(normalText)
                    }
                    // Here we are making the super text or Superscript
                    withStyle(
                            style = SpanStyle(fontSize = superTextStyle,
                                              fontWeight = FontWeight.Normal,
//                                              baselineShift = BaselineShift.Superscript, // (Shifted Up)
                                              baselineShift = BaselineShift.Subscript, // Change the style (Shifted bottom)
                                              )

                    ) {
                        append(superText)
                    }
                }
        )
    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun SuperTextPreview() {
        SuperScriptText("Hello", "world")
    }
}
