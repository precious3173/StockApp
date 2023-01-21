package com.example.stockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.Navigation.BottomNavScreen
import com.example.stockapp.Navigation.Nav
import com.example.stockapp.ViewModel.StockViewModel
import com.example.stockapp.ui.theme.Scan
import com.example.stockapp.ui.theme.StockAppTheme
import com.example.stockapp.ui.theme.ui.BarCodeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


@AndroidEntryPoint
class BottomScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: StockViewModel by viewModels()

        val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
            error("LocalActivity is not present")
        }

        setContent {



            StockAppTheme {



             val navController = rememberNavController()



            androidx.compose.material.Surface(){

                Scaffold(bottomBar = {
                  
                 BottomNavScreen(navController = navController)
                }) {

                    CompositionLocalProvider(LocalActivity provides this@BottomScreen) {

                        Nav(navController)
                    }

                }
            }

            }
        }
    }
}







