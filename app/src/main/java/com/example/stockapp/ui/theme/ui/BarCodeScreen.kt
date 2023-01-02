package com.example.stockapp.ui.theme.ui

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.stockapp.R
import com.example.stockapp.ui.theme.BarScanner
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executors


@Composable
fun BarCodeScreen (navController: NavController){

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)


    val preview = Preview.Builder()
        .build()

    val previewView = remember {
        PreviewView(context)
    }


    cameraProviderFuture.addListener({

        val cameraProvider = cameraProviderFuture.get()
        val imageCapture  = ImageCapture.Builder().build()

        val cameraExecutor = Executors.newSingleThreadExecutor()

        val imageAnalyzer = ImageAnalysis.Builder().build().also {

            it.setAnalyzer(cameraExecutor, BarScanner(context, navController))

        }


        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()


        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture, imageAnalyzer
        )

        preview.setSurfaceProvider(previewView.surfaceProvider)


    }, ContextCompat.getMainExecutor(context))

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        AndroidView({previewView}, modifier = Modifier.fillMaxSize())

        IconButton(
            modifier = Modifier.padding(bottom = 80.dp),
            onClick = {


            },

            content = {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_camera_alt_24),
                    contentDescription = "",
                    tint = Color.Magenta,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(1.dp)
                        .border(10.dp, Color.White, CircleShape)
                )
            }
            )



    }
}

//fun ScanBarCode (
//    imageCapture: ImageCapture,
//c){
//
//    val name = SimpleDateFormat( "yyyy-MM-dd-HH-mm-ss-SSS", Locale.US)
//        .format(System.currentTimeMillis())
//
//    val contentValues = ContentValues().apply {
//        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
//            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
//        }
//    }
//
//
//  val photoFile = File("/sdcard/sample.jpg")
//
//    val outputFileOptions = ImageCapture.OutputFileOptions.Builder(contentResolver,
//        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//        contentValues).build()
//
//
//    imageCapture.takePicture(outputFileOptions, cameraExecutor,
//        object : ImageCapture.OnImageSavedCallback {
//            override fun onError(error: ImageCaptureException)
//            {
//             Toast.makeText(context, error.message, Toast.LENGTH_SHORT)
//            }
//            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
//                val savedUri = Uri.fromFile(File("/sdcard/sample.jpg"))
//                CapturedImage(savedUri)
//            }
//        })
//}




