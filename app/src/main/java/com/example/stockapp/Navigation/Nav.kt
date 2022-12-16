package com.example.stockapp.Navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.R
import com.example.stockapp.SplashScreens

@Composable
fun Nav() {

    val navController = rememberNavController()
    var bottomState by remember {
        mutableStateOf("Stocks")
    }
    NavHost(navController = navController,
        startDestination = "splash_screen"
    ){

        composable("splash_screen"){
            SplashScreens(navController = navController)

        }

        composable("Stocks"){

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,



            )


            {

            }

            Scaffold {

                Scaffold (

                    content = {
                       Box(
                         modifier = Modifier.fillMaxSize(),
                           Alignment.Center
                       ){
                           Text(text = bottomState,
                             fontSize = 25.sp,
                               fontWeight = FontWeight.Bold
                               )
                       }

                    },
                    bottomBar  =  {

                        androidx.compose.material.BottomNavigation(
                           backgroundColor = colorResource(id = R.color.pink)

                        ) {


                            BottomNavigationItem(selected = bottomState == "Stocks" ,
                                onClick = { bottomState = "Stocks"},
                                label = { Text(text = "Stocks")},
                                icon = {Icon( painterResource( R.drawable.ic_baseline_inventory_24),
                                    contentDescription = null)
                                       },

                                )

                            BottomNavigationItem(selected = bottomState == "Scan" ,
                                onClick = { bottomState = "Scan"},
                                label = { Text(text = "Scan")},
                                icon = { Icon(painterResource( id = R.drawable.ic_baseline_qr_code_scanner_24),
                                    contentDescription = null)
                                },

                                )
                            BottomNavigationItem(selected = bottomState == "Report" ,
                                onClick = { bottomState = "Report"},
                                label = { Text(text = "Report")},
                                icon = { Icon(painterResource( id = R.drawable.ic_baseline_bar_chart_24),
                                    contentDescription = null)
                                },

                                )

                            BottomNavigationItem(selected = bottomState == "Settings" ,
                                onClick = { bottomState = "Settings"},
                                label = { Text(text = "Settings")},
                                icon = { Icon(painterResource( R.drawable.ic_baseline_settings_24),
                                    contentDescription = null)
                                },

                                )

//                            when(bottomState){
//
//                              "Scan" ->
                           // }

                        }

                    }
                )


            }

        }
    }
}