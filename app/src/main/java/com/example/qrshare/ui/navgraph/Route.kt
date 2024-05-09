package com.example.qrshare.ui.navgraph

sealed class Route(val route: String) {
    //Navegación de la pantalla de inicio
    object AppStartDestination: Route(route = "appStartDestination")
    object OnBoarding: Route(route = "onBoarding")
    object Login: Route(route = "login")

    //Navegación Principal
    object AppHomeDestination: Route(route = "appHomeDestination")
    object  HomeQr: Route(route = "homeQr")
}