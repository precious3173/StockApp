package com.example.stockapp.Recyclerview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StockItem() {
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp),
    shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
      androidx.compose.material.Surface() {
          Column (
              Modifier
                  .padding(4.dp)
                  .fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally){

              Text(text = "Stock name")
              Text(text = "Stock Location")
              Text(text = "Barcode Number")

          }

      }

    }
}