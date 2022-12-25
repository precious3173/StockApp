package com.example.stockapp.ui.theme

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

@Composable
fun Camera () {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

}

@Composable
fun ActivateCamera(){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val activityResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult ={
                isgranted ->
            if (isgranted){
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
                startCamera(context, lifecycleOwner)
            }
            else{
                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    )


    LaunchedEffect(key1 = true){
        activityResultLauncher.launch(Manifest.permission.CAMERA)
    }
}


fun startCamera (context:Context, lifecycleOwner: LifecycleOwner){

    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

    cameraProviderFuture.addListener({

        val cameraProvider = cameraProviderFuture.get()


        val preview = Preview.Builder()
            .build()

        val previewView = PreviewView(context)
        val imageCapture  = ImageCapture.Builder().build()

         val cameraExecutor = ContextCompat.getMainExecutor(context)

        val imageAnalyzer = ImageAnalysis.Builder().build().also {

            it.setAnalyzer(cameraExecutor, BarScanner())

        }

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        try {


            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture, imageAnalyzer
            )

            preview.setSurfaceProvider(previewView.surfaceProvider)
        } catch (e: Exception){

            Log.e(TAG, "Use case binding failed", e)
        }



    }, ContextCompat.getMainExecutor(context))
}

