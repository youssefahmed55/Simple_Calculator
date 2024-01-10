package com.calculatooor.simple_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calculatooor.simple_calculator.ui.theme.Simple_CalculatorTheme
import com.calculatooor.simple_calculator.views.MainScreen
import com.calculatooor.simple_calculator.views.SplashScreenAnimate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Calculator()
        }
    }
}

@Composable
fun Calculator() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "splash") {
        composable("splash") { SplashScreenAnimate(navHostController) }
        composable("Main") { MainScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Simple_CalculatorTheme {
        Calculator()
    }
}