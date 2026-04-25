package com.example.uptodo.data.models.locals.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "app_prefs")

class DataStoreManager(private val context: Context) {
    object PreferencesKeys {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    suspend fun saveOnBoardingCompleted(context: Context) {
      context.dataStore.edit { preferences ->
          preferences[PreferencesKeys.ONBOARDING_COMPLETED] = true
      }
    }

    fun getOnboardingStatus(context: Context) : Flow<Boolean>{
       return context.dataStore.data.map { preferences ->
          preferences[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
       }
    }

}