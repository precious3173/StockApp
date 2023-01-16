package com.example.stockapp.Database

import android.location.Location
import androidx.room.ColumnInfo
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "Stock")
data class StockEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "stockLocation")
    var stockLocation: String,
    @ColumnInfo(name= "stockName")
    var stockName: String,
    @ColumnInfo(name = "barcode")
    var barcode: String
)