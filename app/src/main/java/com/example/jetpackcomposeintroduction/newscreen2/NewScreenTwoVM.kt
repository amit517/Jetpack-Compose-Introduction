package com.example.jetpackcomposeintroduction.newscreen2

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewScreenTwoVM : ViewModel() {
    private val colors = arrayOf(
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#000000"),
            Color.parseColor("#FF8F00"),
            Color.parseColor("#EF6C00"),
            Color.parseColor("#D84315"),
            Color.parseColor("#37474F"),
            //...more
    )
    fun changeColor() {
        _composeColor.value = colors.random()
    }

    private val _composeColor = MutableStateFlow(colors.random())
    val composeColor: StateFlow<Int> = _composeColor
}
