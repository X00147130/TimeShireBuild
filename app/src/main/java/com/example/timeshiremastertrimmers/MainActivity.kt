package com.example.timeshiremastertrimmers

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timeshiremastertrimmers.screens.Cart
import com.example.timeshiremastertrimmers.screens.Home
import com.example.timeshiremastertrimmers.screens.Payment
import com.example.timeshiremastertrimmers.ui.theme.TimeShireMasterTrimmersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeShireMasterTrimmersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigate()
                }
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = false,
    name = "Dark Mode"
)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    TimeShireMasterTrimmersTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.secondary
        ) {
            Home(
                viewModel(),
                navController,
                modifier = Modifier.border(
                    2.dp,
                    MaterialTheme.colorScheme.secondary,
                    RectangleShape
                )
            )
        }
    }

}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = false,
    name = "Dark Mode"
)

@Composable
fun CartPreview() {
    val navController = rememberNavController()
    TimeShireMasterTrimmersTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.secondary
        ) {
            Cart(
                viewModel(),
                navController,
                modifier = Modifier.border(
                    2.dp,
                    MaterialTheme.colorScheme.secondary,
                    RectangleShape
                )
            )
        }
    }

}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = false,
    name = "Dark Mode"
)
@Composable
fun PaymentPreview() {
    val navController = rememberNavController()
    TimeShireMasterTrimmersTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.secondary
        ) {
            Payment(
                viewModel(),
                navController,
                modifier = Modifier.border(
                    2.dp,
                    MaterialTheme.colorScheme.secondary,
                    RectangleShape
                )
            )
        }
    }
}
@Composable
fun Navigate() {
    val view: CartViewModel = viewModel()
    val navController = rememberNavController()

    //navHost
    NavHost(navController = navController, startDestination = "Home") {
        navigationGraph(view, navController = navController)
    }
}

//NavGraph

fun NavGraphBuilder.navigationGraph(viewModel: CartViewModel, navController: NavController) {

    composable("Home") {
        Home(viewModel, navController)
    }

    composable("Cart") {
        Cart(viewModel, navController)
    }

    composable("Checkout") {
        Payment(viewModel,navController)
    }
}

