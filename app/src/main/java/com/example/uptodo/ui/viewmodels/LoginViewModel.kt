package com.example.uptodo.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.uptodo.data.models.locals.datastore.DataStoreManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val dataStoreManager = DataStoreManager(application)

    val isLoggedIn = dataStoreManager.getIsLoggedIn().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    fun updateLoginStatus(loggedInStatus: Boolean){
        viewModelScope.launch {
            dataStoreManager.handleIsLoggedIn(loggedInStatus)
        }
    }
}