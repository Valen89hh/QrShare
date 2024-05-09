package com.example.qrshare.ui.navgraph

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.qrshare.ui.presentation.onboarding.OnBoardingScreen

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
                OnBoardingScreen()
            }

            composable(route = Route.Login.route){

            }
        }

        navigation(
            route = Route.AppHomeDestination.route,
            startDestination = Route.HomeQr.route
        ){
            composable(route = Route.HomeQr.route){

            }
        }
    }
}