package com.example.stockapp.ui.theme

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.SparseIntArray
import android.view.Surface
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navArgument
import com.example.stockapp.BottomScreen
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage


class BarScanner(context: Context, navController: NavController): ImageAnalysis.Analyzer {

    var context: Context? = null
    var navController: NavController? = null


    init {

        this.context = context
        this.navController = navController

    }

    val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_AZTEC,
            Barcode.FORMAT_CODE_128,
            Barcode.FORMAT_CODE_93,
            Barcode.FORMAT_CODABAR,
            Barcode.FORMAT_EAN_13,
            Barcode.FORMAT_EAN_8,
            Barcode.FORMAT_ITF,
            Barcode.FORMAT_UPC_A,
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_DATA_MATRIX

        )
        .build()

      private val scanner =BarcodeScanning.getClient(options)



    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageproxy: ImageProxy) {



        val mediaImage = imageproxy.image
        if(mediaImage != null){
           val image = InputImage.fromMediaImage(
               mediaImage, imageproxy.imageInfo.rotationDegrees
           )

            scanner.process(image).addOnSuccessListener{
                barcodes ->

              for (barcode in barcodes){

                  val bounds = barcode.boundingBox
                  val corners = barcode.cornerPoints


                  barcode?.rawValue?.let {
                          code ->

                      Toast.makeText(context, code, Toast.LENGTH_LONG).show()

                      navController!!.navigate("Scan/$code")


                  }



              }


            }.addOnFailureListener{
                exception ->

                Toast.makeText(context,"Error: " + exception.message, Toast.LENGTH_SHORT ).show()

            }.addOnCompleteListener{

            }


        }
    }

}

interface scanCode{
    fun setText(code: String){

    }
}


