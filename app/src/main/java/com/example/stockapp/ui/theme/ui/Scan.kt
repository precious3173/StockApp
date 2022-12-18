package com.example.stockapp.ui.theme

import android.widget.Button
import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.stockapp.R

@Composable
fun Scan () {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        Column(  modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally


            ) {
            OutlinedTextField(value = text,

                onValueChange = {
                    newText ->
                    text = newText


                },

                label = {Text(text = "Stock Name")},
                placeholder = { Text(text = "Enter Stock Name")},
                modifier = Modifier.padding(15.dp)
                )

            OutlinedTextField(value = text,

                onValueChange = {
                        newText ->
                    text = newText


                },

                label = {Text(text = "Stock Location")},
                placeholder = { Text(text = "Enter Stock Location")},
                modifier = Modifier.padding(15.dp)
            )
            Button(onClick = { /*TODO*/ }, shape = CutCornerShape(10), colors =ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)) {
                Image(painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24), contentDescription = "",
                modifier = Modifier.size(20.dp).height(15.dp).padding(15.dp))
                Text(text = "Scan Barcode of Stock", Modifier.padding(start = 20.dp))


            }

        }

    }
}