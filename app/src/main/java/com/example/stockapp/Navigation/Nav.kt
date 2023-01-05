package com.example.stockapp.Navigation

import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.util.Log
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.R
import com.example.stockapp.ui.theme.BarScanner
import com.example.stockapp.ui.theme.Reports
import com.example.stockapp.ui.theme.Scan
import com.example.stockapp.ui.theme.Stock
import com.example.stockapp.ui.theme.ui.BarCodeScreen
import com.example.stockapp.ui.theme.ui.Settings
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import java.util.concurrent.Executors
import java.util.jar.Manifest

@Composable
fun Nav(navController: NavHostController) {

    NavHost(navController = navController,
        startDestination = "Stocks"
    ){



        composable("Stocks"){
            Stock()

        }

        composable("Scan/{Code}"){

            val getvalue = it.arguments?.getString("Code" )
             Scan(navController, code = getvalue)

            }

        composable("Reports"){
            Reports()

        }

        composable("Settings"){
            Settings()

        }

        composable("BarCodeScreen"){
            BarCodeScreen(navController)
        }
        }

    }
