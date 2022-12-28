package com.example.stockapp.ui.theme

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.camera2.internal.annotation.CameraExecutor
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor




@Composable
fun Scan (navController: NavController) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

//    val activityResultLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.RequestPermission(),
//        onResult ={
//                isgranted ->
//            if (isgranted){
//                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
//                navController.navigate("Camera")
//            }
//            else{
//                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//    )
//
//
//    LaunchedEffect(key1 = true){
//        activityResultLauncher.launch(Manifest.permission.CAMERA)
//    }

    val fileFormat = "yyyy-MM-dd-HH-mm-ss-SSS"




    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        Column(  modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally


            ) {
            OutlinedTextField(value = text,

                onValueChange = {
                    newText ->
                    text = newText


                },

                label = {Text(text = "Stock Name")},
                placeholder = { Text(text = "Enter Stock Name")},
                modifier = Modifier.padding(15.dp)
                )

            OutlinedTextField(value = text,

                onValueChange = {
                        newText ->
                    text = newText


                },

                label = {Text(text = "Stock Location")},
                placeholder = { Text(text = "Enter Stock Location")},
                modifier = Modifier.padding(15.dp)
            )
            OutlinedTextField(value = text,

                onValueChange = {
                        newText ->
                    text = newText


                },

                label = {Text(text = "Barcode Number")},
                placeholder = { Text(text = "Barcode Number")},
                modifier = Modifier.padding(15.dp)
            )
            Button(

                onClick =  {

                    navController.navigate("BarCodeScreen")

            }, shape = CutCornerShape(10), colors =ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)) {
                Image(painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24), contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .height(15.dp)
                    .padding(15.dp))
                Text(text = "Scan Stock Barcode", Modifier.padding(start = 20.dp))


            }


        }

    }
}

//fun onClick(
//    imageCapture: ImageCapture,
//    cameraExecutor: Executor,
//    context: Context,
//    CapturedImage: (Uri) -> Unit
//
//) {
//
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


fun RequestCamera(context: Context) =
        ContextCompat.checkSelfPermission(
            context, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED


