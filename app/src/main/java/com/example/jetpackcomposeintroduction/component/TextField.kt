package com.example.jetpackcomposeintroduction.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

/**
 * BasicTextField Don't have property like label, trailingIcon, leadingIcon.
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCustom() {
    var text by remember {
        mutableStateOf("Type here")
    }

    Column(modifier = Modifier
        .fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center) {
        BasicTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                /*placeholder = { Text(text = "Enter text here...") },*/
                /*enabled = false,*/ // enable/disable state
                /*readOnly = true,*/ // Keyboard won't shown. But user can select and copy text from it,
                /*label = {
                      Text(text = "Title")
                  },*/ // this label will be always visible
                /*singleLine = true, */ // Will make the text field scrollable
                /*maxLines = 2,*/ // If singleLine is in use, maxLines will be ignored
                /*leadingIcon = {
                    IconButton(onClick = { *//*TODO*//* }) {
                        Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email Icon"
                        )
                    }
                },
                trailingIcon = {
                    if (text.isNotBlank()) {
                        IconButton(onClick = { text = "" }) {
                            Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear Icon"
                            )
                        }
                    }
                },*/
                keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                        onSearch = {
                            Log.d("ImeAction", "Ime Action CLicked")
                        }
                ))
    }
}
