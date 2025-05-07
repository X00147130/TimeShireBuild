package com.example.timeshiremastertrimmers.ViewModels


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
                        id = "",
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
            /*db.collection("carts").document(userId).*//*update*//*(productId to FieldValue.delete())*/
        }else{
            db.collection("carts").document(userId).update(
                mapOf(productId to mapOf("quantity" to currentQty - 1))
            )
        }

    }
}



