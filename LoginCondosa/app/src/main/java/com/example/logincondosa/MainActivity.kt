package com.example.logincondosa

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.logincondosa.ui.login.ui.ForgotScreen
import com.example.logincondosa.ui.login.ui.ForgotViewModel
import com.example.logincondosa.ui.login.ui.LoginScreen
import com.example.logincondosa.ui.login.ui.LoginViewModel
import com.example.logincondosa.ui.theme.LoginCondosaTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            LoginCondosaTheme {
                // Crea un NavController
                val navController = rememberNavController()

                // Define el NavHost con las rutas
                NavHost(
                    navController = navController,
                    startDestination = "loginScreen"
                ) {
                    composable("loginScreen") {
                        LoginScreen(LoginViewModel())
                    }

//                    composable("registerScreen") {
//                        RegisterScreen(RegisterViewModel())
//                    }
                    composable("forgotScreen") {
                        ForgotScreen(ForgotViewModel())
                    }
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}



