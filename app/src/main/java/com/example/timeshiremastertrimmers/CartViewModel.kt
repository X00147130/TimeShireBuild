package com.example.timeshiremastertrimmers


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.timeshiremastertrimmers.Data.CartItem
import com.example.timeshiremastertrimmers.Data.Product
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

class CartViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val userId = "AIzaSyBTV3HuMSF9GYIYKDw46ALb6hlMdAEptGA"

    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var cartItems by mutableStateOf<Map<String, CartItem>>(emptyMap())
        private set

    init {
        fetchProducts()
        listenToCart()
    }

    private fun fetchProducts() {
        db.collection("products").get().addOnSuccessListener { result ->
            products = result.mapNotNull { it.toObject(Product::class.java) }
        }

    }

    private fun listenToCart() {
        db.collection("carts").document(userId)
            .addSnapshotListener { snapshot, _ ->
                val map = snapshot?.data ?: return@addSnapshotListener
                cartItems = map.mapValues {
                    val value = it.value as Map<*, *>
                    CartItem(
                        product = it.key,
                        quantity = (value["quantity"] as Long?)?.toInt() ?: 1
                    )
                }
            }
    }

    fun addToCart(productId: String) {
        val currentQty = cartItems[productId]?.quantity ?: 0
        db.collection("carts").document(userId).update(
            mapOf(productId to mapOf("quantity" to currentQty + 1))
        ).addOnFailureListener {
            //if doc doesnt exist create it
            db.collection("carts").document(userId).set(
                mapOf(productId to mapOf("quantity" to 1))
            )
        }
    }

    fun removeFromCart(productId: String){
        val currentQty = cartItems[productId]?.quantity ?: return
        if (currentQty <= 1){
            db.collection("carts").document(userId).update(productId to FieldValue.delete())
        }else{
            db.collection("carts").document(userId).update(
                mapOf(productId to mapOf("quantity" to currentQty - 1))
            )
        }

    }
}


/* private val _products = listOf(
     Product(1, "Lime", 14.99, R.drawable.lime),
     Product(2, "Brown", 14.99, R.drawable.brown),
     Product(3, "Beige", 14.99, R.drawable.beige),
     Product(4, "Salmon", 14.99, R.drawable.salmon),
     Product(4, "Blue", 14.99, R.drawable.blue),
     Product(4, "Silver", 14.99, R.drawable.silver),
     Product(4, "Orange", 14.99, R.drawable.orange),
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
     Column(modifier = Modifier.fillMaxSize()) {
         LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
             items(viewModel.products) { product ->
                 Column(modifier = Modifier.padding(start = 25.dp, bottom = 30.dp)) {
                     Image(
                         painter = painterResource(product.image),
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
}*/


