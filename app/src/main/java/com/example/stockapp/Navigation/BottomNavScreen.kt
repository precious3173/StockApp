package com.example.stockapp.Navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stockapp.R

@Composable
fun BottomNavScreen (navController: NavController) {

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white)

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        BottomNavigationItem(

            selected = currentDestination?.route == "Stocks",
            onClick = {navController.navigate("Stocks")},
            label = { Text(text = "Stocks") },
            icon = {
                Icon(
                    painterResource(R.drawable.ic_baseline_inventory_24),
                    contentDescription = null,
                    tint = Color.Magenta
                )
            },

            )

        BottomNavigationItem(selected = currentDestination?.route == "Scan" ,
            onClick = { navController.navigate("Scan")},
            label = { Text(text = "Scan") },
            icon = { Icon(
                painterResource( id = R.drawable.ic_baseline_qr_code_scanner_24),
                contentDescription = null,
                tint = Color.Magenta)

            }


        )
        BottomNavigationItem(selected = currentDestination?.route  == "Reports" ,
            onClick = { navController.navigate( "Reports")},
            label = { Text(text = "Reports") },
            icon = { Icon(
                painterResource( id = R.drawable.ic_baseline_bar_chart_24),
                contentDescription = null,
                tint = Color.Magenta)
            },

            )

        BottomNavigationItem(selected = currentDestination?.route == "Settings" ,
            onClick = { navController.navigate( "Settings")},
            label = { Text(text = "Settings") },
            icon = { Icon(
                painterResource( R.drawable.ic_baseline_settings_24),
                contentDescription = null,
                tint = Color.Magenta)
            },

            )



    }

}

