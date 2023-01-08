package com.example.stockapp.Recyclerview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StockItem() {
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp).background(color = Color.Magenta),
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

              Text(text = "Stock name", modifier = Modifier.background(color = Color.White).padding(10.dp), style = MaterialTheme.typography.caption, fontSize = 18.sp)
              Text(text = "Stock Location", modifier = Modifier.background(color = Color.White).padding(10.dp), style = MaterialTheme.typography.caption, fontSize = 18.sp)
              Text(text = "Barcode Number", modifier = Modifier.background(color = Color.White).padding(10.dp), style = MaterialTheme.typography.caption, fontSize = 18.sp)

          }

      }

    }
}