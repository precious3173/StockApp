package com.example.stockapp.ui.theme

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.util.SparseIntArray
import android.view.Surface
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarScanner: ImageAnalysis.Analyzer {

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
                barcode ->



            }.addOnFailureListener{
                exception ->

                Log.e(TAG,"Error: " + exception.message )

            }.addOnCompleteListener{

            }


        }
    }

}

