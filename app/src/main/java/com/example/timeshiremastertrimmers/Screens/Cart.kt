package com.example.timeshiremastertrimmers.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.timeshiremastertrimmers.R
import com.example.timeshiremastertrimmers.ui.theme.TimeShireMasterTrimmersTheme


class Cart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeShireMasterTrimmersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cart(
                    )
                }
            }
        }
    }
}


@Composable
fun Cart(navController: NavController, modifier: Modifier = Modifier) {

    /*Used to track the icon click state*/
    val isExpanded = remember { mutableStateOf(false) }

    /*Drop Down Menu list*/
    val pages = listOf("Home", "Shopping Cart")

    /*used to remember the position for pages index*/
    val itemPosition = remember { mutableStateOf(0) }

    /*Box for header row*/
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Row(
            modifier = Modifier
                .background(Color(30, 18, 5))
                .height(100.dp)
                .fillMaxSize()
                .padding(start = 95.dp, top = 23.dp, end = 8.dp, bottom = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vintage_coach_trimmers),
                contentDescription = "TimeShire Master Trimmers Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(210.dp)
            )
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 120.dp, top = 350.dp)) {
            Text(
                text = "Cart Is Empty",
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 110.dp, top = 600.dp)
        ) {

            Row(
                modifier = Modifier
                    .background(Color(30, 18, 5)),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(
                    onClick = { navController.navigate("Checkout") },
                    colors = ButtonColors(
                        Color(30, 18, 4),
                        Color.Black,
                        Color(30, 18, 4),
                        Color.Black
                    ),
                    modifier = Modifier.size(width = 180.dp, height = 50.dp)
                ) {
                    Text(
                        text = "Proceed to Checkout",
                        fontFamily = FontFamily.Cursive,
                        color = Color.White,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}

