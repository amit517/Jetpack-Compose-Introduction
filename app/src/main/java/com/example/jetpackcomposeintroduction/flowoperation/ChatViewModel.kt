package com.example.jetpackcomposeintroduction.flowoperation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ChatViewModel : ViewModel() {

    private val isLoggedIn = MutableStateFlow(true)
    private val chatMessage = MutableStateFlow<List<ChatMessage>>(emptyList())
    private val users = MutableStateFlow<List<User>>(emptyList())

    val chatState = combine(isLoggedIn, chatMessage, users) { isLoggedIn, messages, users ->
        if (isLoggedIn) {
            ChatState(
                    userPreview = users.map { curUser->
                        UserPreview(
                                user = curUser,
                                lastMessage = messages.filter { it.user == curUser }.maxByOrNull { it.time } ?.message
                        )
                    },
                    headerTitle = users.firstOrNull()?.type ?: "Chat title"
            )
        } else null
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
}

data class ChatState(
    val userPreview: List<UserPreview>,
    val headerTitle: String
)

data class UserPreview(
    val user: User,
    val lastMessage: String?
)

data class ChatMessage(
    val user: User,
    val message: String,
    val time: Long
)
