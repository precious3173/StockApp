package com.example.stockapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.Navigation.Nav
import com.example.stockapp.ui.theme.StockAppTheme
import kotlinx.coroutines.delay

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val navController = rememberNavController()
            StartScreen()
        }

        }
    }
@Composable
fun StartScreen() {

    val context = LocalContext.current
    LaunchedEffect(key1 = true){

        delay(2000L)

       context.startActivity(Intent(context, BottomScreen::class.java))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Text(text = " Inven3 Manager", fontWeight = FontWeight.Bold,
            fontSize = 35.sp,color = Color.Black, fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(20.dp)

        )

        Icon(
            imageVector = Icons.Default.ShoppingCart,
            tint = Color.Green,
            contentDescription = "Safer way to manage inventory",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp))


    }
}

