package com.example.stockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.Navigation.Nav
import kotlinx.coroutines.delay


class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Nav()


            var animation by remember {

                mutableStateOf(false)
            }
            var anime = animateFloatAsState(
                targetValue = if(animation) 1f else 0f,
                 animationSpec = tween(
                     durationMillis = 5000
                 )
                )

            }
        }
    }


@Composable
fun SplashScreens(navController: NavHostController){


    LaunchedEffect(key1 = true){

        delay(3000L)

        navController.navigate("Stocks"){
           // popUpTo("home")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Text(text = "Inventory Manager", fontWeight = FontWeight.Bold,
            fontSize = 35.sp,color = Color.White, fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(20.dp)

        )

        Image(painter = painterResource(id = R.drawable.inventory),
            contentDescription = "",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp))
        

    }
}

@Composable
@Preview
fun SplashScreenPreview(){
    SplashScreen()
}




