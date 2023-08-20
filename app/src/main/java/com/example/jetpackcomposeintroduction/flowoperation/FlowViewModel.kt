package com.example.jetpackcomposeintroduction.flowoperation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    private val _usersList = MutableStateFlow(emptyList<User>())
    val usersList: StateFlow<List<User>> = _usersList

    val localUsers = usersList.map { users ->
        users.find { it.type == "local" }
    }.stateIn(viewModelScope,
              SharingStarted.WhileSubscribed(5000),
              emptyList<User>())

    fun onUserJoined(user: User) {
        _usersList.update {
            it + user
        }
    }

    fun onUserUpdates(user: User) {
        _usersList.update {
            it.map { curUser ->
                if (curUser.id == user.id) user else curUser
            }
        }
    }

    init {
        viewModelScope.launch {
            usersList.collect {
                println(it)
            }
        }
        viewModelScope.launch {
            localUsers.collect {
                println(it)
            }
        }
    }
}

data class User(val id: String, val type: String)
