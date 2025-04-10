package com.example.timeshiremastertrimmers.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.timeshiremastertrimmers.R
import com.example.timeshiremastertrimmers.ui.theme.TimeShireMasterTrimmersTheme


@Composable
fun Home(navController: NavController, modifier: Modifier = Modifier) {

    /*Used to track the icon click state*/
    val isClicked = remember { mutableStateOf(false) }

    val copyright = "Copyright \u00a9 2025, Dean Conway";

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





        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 124.dp)
                .verticalScroll(rememberScrollState())

        ) {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(horizontal = 100.dp)
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
            )
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.lime),
                        contentDescription = "Lime Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle Shape
                    )

                    Text(
                        text = "       Lime\nPrice: €15:00"
                    )
                }

                Column(
                    horizontalAlignment = AbsoluteAlignment.Right,
                    modifier = Modifier
                        .padding(start = 55.dp, top = 10.dp, end = 30.dp)

                ) {
                    Image(
                        painter = painterResource(R.drawable.brown),
                        contentDescription = "Brown Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle Shape
                    )
                    Text(
                        text = "      Brown \nPrice: €15:00"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.beige),
                        contentDescription = "Beige Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle Shape
                    )
                    Text(text = "      Beige\n Price: €15:00")
                }

                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 55.dp, top = 10.dp, end = 30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.brown),
                        contentDescription = "Brown Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle Shape
                    )
                    Text(
                        text = "      Brown \n" +
                                "Price: €15:00"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.salmon),
                        contentDescription = "Salmon Coloured Seat Belt",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Black, CircleShape)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "     Salmon\n" +
                                " Price: €15:00"
                    )
                }
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 55.dp, top = 10.dp, end = 30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.orange),
                        contentDescription = "Orange Coloured Seat Belt",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Black, CircleShape)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "     Orange\nPrice: €15:00"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            )
            {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.blue),
                        contentDescription = "Blue Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle ShapecontentScale = ContentScale.Crop,                               //Crops the content to size
                    )
                    Text(
                        text = "      Blue\nPrice: €15:00"
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 55.dp, top = 10.dp, end = 30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.mint),
                        contentDescription = "Mint Coloured Seat Belt",
                        contentScale = ContentScale.Crop,                               //Crops the content to size
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                2.dp,
                                Color.Black,
                                CircleShape
                            )                                                           //Creates a Circular Shaped Border colored black
                            .clip(CircleShape)                                          //Clips to a Circle Shape

                    )

                    Text(
                        text = "       Mint\nPrice: €15:00"
                    )
                }
            }

            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.salmon),
                        contentDescription = "Salmon Coloured Seat Belt",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Black, CircleShape)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "     Salmon\n" +
                                " Price: €15:00"
                    )
                }
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 55.dp, top = 10.dp, end = 30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.orange),
                        contentDescription = "Orange Coloured Seat Belt",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Black, CircleShape)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "     Orange\nPrice: €15:00"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            ) {
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp, end = 55.dp)
                ) {
                    Text(text = copyright,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 10.dp,top = 20.dp ,bottom = 60.dp)
                    )
                }
            }
        }
    }
}

