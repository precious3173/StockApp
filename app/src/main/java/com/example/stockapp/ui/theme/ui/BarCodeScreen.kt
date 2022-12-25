package com.example.stockapp.ui.theme.ui

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.stockapp.ui.theme.Camera

@Composable
fun BarCodeScreen (){
    val context = LocalContext.current



}



@Composable
fun cameraPermission() {

    val context = LocalContext.current
    when {
        ContextCompat.checkSelfPermission(
            context, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
        -> Log.d(ContentValues.TAG, "Permission granted")
    }
    ActivityCompat.shouldShowRequestPermissionRationale(
        context as Activity, Manifest.permission.CAMERA
    )

}

