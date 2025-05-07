package com.example.timeshiremastertrimmers.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timeshiremastertrimmers.ViewModels.CartViewModel
import com.example.timeshiremastertrimmers.R
import com.example.timeshiremastertrimmers.ui.theme.TimeShireMasterTrimmersTheme

class Payment : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeShireMasterTrimmersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Payment(
                    )
                }
            }
        }
    }
}


@Composable
fun Payment(viewModel: CartViewModel, navController: NavController, modifier: Modifier = Modifier) {

    /*Used to track the icon click state*/
    val isExpanded = remember { mutableStateOf(false) }

    /*Drop Down Menu list*/
    val pages = listOf("Home", "Gallery", "Material", "How to Find Us")

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
                .padding(top = 23.dp, start = 8.dp, end = 8.dp, bottom =12.dp)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vintage_coach_trimmers),
                contentDescription = "TimeShire Master Trimmers Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(210.dp),
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            isExpanded.value = true
                        }
                    ) {
                    }


                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 150.dp)) {
                        Box() {
                            Row() {
                                val viewModel: CartViewModel = viewModel()

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                ) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Divider()
                                    /*CartView(viewModel)*/
                                }
                            }
                        }
                    }


                }
            }
        }
    }
}