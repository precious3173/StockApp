package com.example.stockapp.ui.theme

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stockapp.Database.StockEntity
import com.example.stockapp.R
import com.example.stockapp.ViewModel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor




@Composable
fun Scan (navController: NavController, code: String? = null, stockViewModel: StockViewModel) {

    val TAG = "Scan"
   // val stockViewModel: StockViewModel = viewModel()

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val stockUiState by stockViewModel.stockData.collectAsState()

    val composeView = LocalView.current
    val activityViewModel = composeView.findViewTreeViewModelStoreOwner()?.let {
        hiltViewModel<StockViewModel>(it)
    }




//    val activityResultLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.RequestPermission(),
//        onResult ={
//                isgranted ->
//            if (isgranted){
//                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
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



    var stockLocationText by remember {
        mutableStateOf("")
    }
    var stockNameText by remember {
        mutableStateOf("")
    }
        var stockLocationTextString by remember {
            mutableStateOf(stockUiState.stockLocation)
        }
    var stockNameTextString by remember {
        mutableStateOf(stockUiState.stockName)
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
            OutlinedTextField(value = stockNameText,

                onValueChange = {
                    newText ->
                    stockNameText = newText

                    stockNameTextString = stockNameText

                },

                label = {Text(text = "Stock Name")},
                placeholder = { Text(text = "Stock Name")},
                modifier = Modifier.padding(15.dp)
                )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = stockLocationText,

                onValueChange = {

                    stockLocationText = it

                    stockLocationTextString = stockLocationText;


                },

                label = {Text(text = "Stock Location")},
                placeholder = { Text(text = "Stock Location")},
                modifier = Modifier.padding(15.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = "",

                onValueChange = { code
                } ,

                label = {Text(text = "Barcode")},
                placeholder = { Text(text = "Barcode")},
                modifier = Modifier
                    .padding(15.dp)
                    .focusable(enabled = false)
            )
            
            Spacer(modifier = Modifier.height(10.dp))
            Button(

                onClick =  {

                    navController.navigate("BarCodeScreen")

            }, shape = CutCornerShape(10), colors =ButtonDefaults.buttonColors(backgroundColor = Color.Magenta))

            {
                Image(painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24), contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .height(15.dp)
                    .padding(15.dp))
                Text(text = "Scan Stock Barcode", Modifier.padding(start = 20.dp))


            }
            Button(onClick = {

                if(!stockNameText.isEmpty() && !stockLocationText.isEmpty()){

                    activityViewModel!!.insertStock( StockEntity( stockLocationTextString, stockName= stockNameTextString, barcode = "code"))

                    Log.e(TAG, "Scan:stockLocationis $stockLocationTextString")
                    Log.e(TAG, "Scan:stockLocationis $stockNameTextString")

                    //     stockViewModel.insertStock(addStock)
                    navController.navigate("Stocks")
                }else{

                    Toast.makeText(context, "Field is empty", Toast.LENGTH_SHORT).show()

                }

            },

                shape = CutCornerShape(10), colors =ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
            ) {

                Image(painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24), contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .height(15.dp)
                        .padding(15.dp))
                Text(text = "Add Stock", Modifier.padding(start = 20.dp))
            }



        }

    }
}


fun RequestCamera(context: Context) =
        ContextCompat.checkSelfPermission(
            context, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED


