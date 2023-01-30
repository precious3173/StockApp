package com.example.stockapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Recyclerview.StockItem
import com.example.stockapp.ViewModel.StockViewModel

@Preview
@Composable
fun Stock () {

    val stockViewModel: StockViewModel = hiltViewModel()
    val stocks: List<StockEntity> by stockViewModel.getStock().collectAsState(listOf())
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
                 horizontalAlignment = Alignment.CenterHorizontally
            ){

            Text(
                text = "Stocks",
                fontSize = 30.sp,
                color = Color.Magenta,
                style = TextStyle(fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive)
            )
               Spacer(modifier = Modifier.height(10.dp))

            LazyColumn( modifier = Modifier
                .fillMaxSize()
                .padding(10.dp) ){

                items(stocks){ item->
                    Column() {
                        StockItem(item)
                    }


                }
            }


        }
    }

}