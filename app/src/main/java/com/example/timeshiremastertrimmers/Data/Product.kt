package com.example.timeshiremastertrimmers.Data

data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

data class CartItem(
    val product: Product,
    var quantity: Int
)