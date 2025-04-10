package com.example.timeshiremastertrimmers

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timeshiremastertrimmers.Screens.Cart
import com.example.timeshiremastertrimmers.Screens.Home
import com.example.timeshiremastertrimmers.Screens.Checkout

//NavHost
@Composable
fun Navigate(){
    val navController = rememberNavController()

    //navHost
    NavHost(navController = navController, startDestination = "Home"){
        navigationGraph(navController = navController)
    }
}

//NavGraph

fun NavGraphBuilder.navigationGraph(navController: NavController){

    composable("Home") {
        Home(navController)
    }

    composable("Cart"){
        Cart(navController)
    }

    composable("Checkout"){
        Checkout(navController)
    }
}