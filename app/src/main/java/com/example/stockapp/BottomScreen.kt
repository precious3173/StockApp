package com.example.stockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.Navigation.BottomNavScreen
import com.example.stockapp.Navigation.Nav
import com.example.stockapp.ui.theme.Scan
import com.example.stockapp.ui.theme.StockAppTheme
import com.example.stockapp.ui.theme.ui.BarCodeScreen
import kotlinx.coroutines.delay


class BottomScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            StockAppTheme {


             val navController = rememberNavController()


                //Scan(navController)
            androidx.compose.material.Surface(){

                Scaffold(bottomBar = {
                  
                 BottomNavScreen(navController = navController)
                }) {
                    Nav(navController)
                }
            }

            }
        }
    }
}







