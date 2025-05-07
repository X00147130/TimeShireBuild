package com.example.timeshiremastertrimmers.ViewModels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.timeshiremastertrimmers.Data.Product
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun ProductView(modifier: Modifier = Modifier, categoryId: String) {
    val productsList = remember {
        mutableStateOf<List<Product>>(emptyList())
    }

    LaunchedEffect(key1 = Unit) {
        Firebase.firestore.collection("products")
            .get().addOnCompleteListener() {
                if (it.isSuccessful) {
                    val resultList = it.result.documents.mapNotNull { doc ->
                        doc.toObject(Product::class.java)
                    }
                    productsList.value = resultList
                }
            }
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(productsList.value) { item ->
            ProductItem(product = item)
        }

    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier.size(200.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.title, textAlign = TextAlign.Center)
        }
    }
}
