package com.example.uptodo.screen.onboarding


import android.app.Application
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.application
import androidx.lifecycle.viewModelScope
import com.example.uptodo.data.models.locals.datastore.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OnboardingViewModel(application: Application) : AndroidViewModel(application) {
    // Datastore instance
    private val dataStoreManager = DataStoreManager(application)
    private val _isLoading = MutableStateFlow(true);
    val isLoading = _isLoading.asStateFlow();

    val isOnboardingCompleted: StateFlow<Boolean> = dataStoreManager.getOnboardingStatus(application)
        .onEach { _isLoading.value = false }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false,
        )

    fun saveOnboardingStatus(){
        viewModelScope.launch {
            dataStoreManager.saveOnBoardingCompleted(application)
        }
    }
}