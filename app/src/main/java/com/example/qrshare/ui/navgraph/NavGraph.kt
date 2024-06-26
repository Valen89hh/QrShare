package com.example.qrshare.ui.navgraph

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.qrshare.ui.presentation.access.AccessScreen
import com.example.qrshare.ui.presentation.login.LoginScreen
import com.example.qrshare.ui.presentation.login.LoginViewModel
import com.example.qrshare.ui.presentation.onboarding.OnBoardingScreen
import com.example.qrshare.ui.presentation.qr.QrScreen

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination  = startDestination){
        navigation(
            route = Route.AppStartDestination.route,
            startDestination = Route.OnBoarding.route
        ){
            composable(route = Route.OnBoarding.route){
                OnBoardingScreen{
                    navController.navigate(Route.Access.route)
                }
            }

            composable(route = Route.Access.route){
                AccessScreen{
                    navController.navigate(Route.Login.route+"/$it")
                }
            }

            composable(route = Route.Login.route+"/{mode}"){backStackEntry ->
                val param: String = backStackEntry.arguments?.getString("mode") ?: "Not"
                val loginViewModel: LoginViewModel = hiltViewModel()
                LoginScreen(mode = param, loginViewModel){
                    navController.navigate(Route.AppHomeDestination.route){
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            inclusive = true
                        }
                    }
                }
            }
        }

        navigation(
            route = Route.AppHomeDestination.route,
            startDestination = Route.HomeQr.route
        ){
            composable(route = Route.HomeQr.route){
                QrScreen()

            }
        }
    }
}