package com.example.timeshiremastertrimmers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.timeshiremastertrimmers.Data.CartItem
import com.example.timeshiremastertrimmers.Data.Product

class CartViewModel : ViewModel() {

    private val _products = listOf(
        Product(1, "Lime", 14.99),
        Product(2, "Brown", 14.99),
        Product(3, "Beige", 14.99),
        Product(4, "Salmon", 14.99)
    )

    val products: List<Product> get() = _products

    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems


    fun addToCart(product: Product) {
        val item = _cartItems.find { it.product.id == product.id }
        if (item != null) {
            item.quantity++
        } else {
            _cartItems.add(CartItem(product, 1))
        }
    }


    fun removeFromCart(product: Product) {
        val item = _cartItems.find { it.product.id == product.id }
        item?.let {
            if (it.quantity > 1) it.quantity--
            else _cartItems.remove(it)
        }
    }

    fun getTotal(): Double {
        return _cartItems.sumOf {
            it.product.price * it.quantity
        }
    }
}


@Composable
fun ProductList(viewModel: CartViewModel) {

    Column {
        Text("Products", fontSize = 24.sp, modifier = Modifier.padding(bottom = 20.dp))
        LazyColumn {
            items(viewModel.products) { product ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.lime),
                            contentDescription = product.name + " Coloured Seat Belt",
                            contentScale = ContentScale.Crop,                               //Crops the content to size
                            modifier = Modifier
                                .padding(start = 40.dp)
                                .size(100.dp)
                                .border(
                                    2.dp,
                                    Color.Black,
                                    CircleShape
                                )                                                           //Creates a Circular Shaped Border colored black
                                .clip(CircleShape)                                          //Clips to a Circle Shape

                        )
                        Text(product.name, /*textAlign = Alignment.Center*/ modifier = Modifier.padding(start = 70.dp))
                        Text("$${product.price}", modifier = Modifier.padding(start = 65.dp))

                        Button(
                            onClick = { viewModel.addToCart(product) },
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            modifier = Modifier.padding(start = 30.dp)
                        ) {
                            Text("Add to Cart", color = Color.White)
                        }
                    }

                    Column(modifier = Modifier.padding(start = 50.dp)) {
                        Image(
                            painter = painterResource(R.drawable.brown),
                            contentDescription = product.name + " Coloured Seat Belt",
                            contentScale = ContentScale.Crop,                               //Crops the content to size
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(100.dp)
                                .border(
                                    2.dp,
                                    Color.Black,
                                    CircleShape
                                )                                                           //Creates a Circular Shaped Border colored black
                                .clip(CircleShape)                                          //Clips to a Circle Shape


                        )
                        Text(product.name, modifier = Modifier.padding(start = 37.dp))
                        Text("$${product.price}", modifier = Modifier.padding(start = 30.dp))

                        Button(
                            onClick = { viewModel.addToCart(product) },
                            modifier = Modifier.padding(end = 30.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text("Add to Cart", color = Color.White)
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun CartView(viewModel: CartViewModel) {
    Column {
        Text("Cart", fontSize = 24.sp)
        LazyColumn {
            items(viewModel.cartItems) { cart ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${cart.product.name} x${cart.quantity}")
                    Row {
                        IconButton(onClick = { viewModel.removeFromCart(cart.product) }) {
                            Icon(Icons.Default.Clear, contentDescription = "Remove")
                        }
                        IconButton(onClick = { viewModel.addToCart(cart.product) }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }
            }
        }
        Text("Total: $${String.format("%.2f", viewModel.getTotal())}")
    }
}
