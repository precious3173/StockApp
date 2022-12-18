package com.example.stockapp.ui.theme

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat

@Composable
fun Camera (){

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current


    val cameraProvider = remember {
        ProcessCameraProvider.getInstance(context)
    }

    val cameraProviderFuture = remember {

        cameraProvider.get()
    }


    var cameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }


    val activityResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult ={
                granted ->
            cameraPermission = granted
        }
    )


    LaunchedEffect(key1 = true){
        activityResultLauncher.launch(Manifest.permission.CAMERA)
    }
}