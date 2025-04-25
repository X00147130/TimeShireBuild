package com.example.timeshiremastertrimmers.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timeshiremastertrimmers.CartViewModel
import com.example.timeshiremastertrimmers.ProductList
import com.example.timeshiremastertrimmers.R

@Composable
fun Home(viewModel: CartViewModel, navController: NavController, modifier: Modifier = Modifier) {

    val copyright = "Copyright \u00a9 2025, Dean Conway"

    /*Used to track the icon click state*/
    val isClicked = remember { mutableStateOf(false) }

    /*Box for header row*/
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Row(
            modifier = Modifier
                .background(Color(30, 18, 5))
                .padding(top = 23.dp, start = 8.dp, end = 8.dp, bottom = 12.dp)
                .height(100.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.vintage_coach_trimmers),
                contentDescription = "TimeShire Master Trimmers Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(210.dp)

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
                            isClicked.value = true
                        }
                    ) {
                        Button(
                            onClick = { navController.navigate("Cart") },
                            colors = ButtonColors(
                                Color(30, 18, 4),
                                Color.Black,
                                Color(30, 18, 4),
                                Color.Black
                            )
                        )
                        {
                            Image(
                                painter = painterResource(id = R.drawable.shopping_cart),
                                contentDescription = "Shopping Cart"
                            )
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 150.dp)
        ) {
            Row() {
                val viewModel: CartViewModel = viewModel()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp, bottom = 100.dp)
                ) {
                    ProductList(viewModel)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 590.dp)
                    .background(color = Color(0, 0, 0))
                    .height(100.dp),

            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp)
                ) {
                    Text(
                        text = copyright,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 75.dp, top = 30.dp, bottom = 60.dp)
                    )
                }
            }
        }
    }
}