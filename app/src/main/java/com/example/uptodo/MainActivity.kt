package com.example.uptodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uptodo.ui.theme.UpTodoTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uptodo.data.models.locals.datastore.DataStoreManager
import com.example.uptodo.screen.LoginScreen
import com.example.uptodo.screen.OnboardingScreen
import com.example.uptodo.screen.RegisterScreen
import com.example.uptodo.screen.Screen
import com.example.uptodo.screen.StartScreen
import com.example.uptodo.screen.onboarding.OnboardingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        val viewModel: OnboardingViewModel by viewModels()

        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        enableEdgeToEdge()
        setContent {
            val isOnboardingCompleted by viewModel.isOnboardingCompleted.collectAsState()
            val isLoading by viewModel.isLoading.collectAsState()
            UpTodoTheme {

                if(!isLoading) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = if (isOnboardingCompleted) Screen.Start else Screen.Onboarding
                    ){
                        composable<Screen.Onboarding> {
                            OnboardingScreen {
                                navController.navigate(Screen.Start){
                                    popUpTo(Screen.Onboarding){
                                        inclusive = true
                                    }
                                }
                            }
                        }
                        composable<Screen.Start> {
                            StartScreen(
                                onLoginClick = {
                                    navController.navigate(Screen.Login)
                                },
                                onRegisterClick = {
                                    navController.navigate(Screen.Register)
                                }
                            )
                        }
                        composable<Screen.Login> {
                            LoginScreen()
                        }
                        composable<Screen.Register> {
                            RegisterScreen()
                        }
                        composable<Screen.Home> {
                            Surface(modifier = Modifier.fillMaxSize()) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("Home Screen")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UpTodoTheme {
        Greeting("Android")
    }
}