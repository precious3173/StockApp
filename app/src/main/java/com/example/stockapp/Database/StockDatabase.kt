package com.example.stockapp.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [StockEntity::class], version = 1,
    exportSchema = true,)
abstract class StockDatabase : RoomDatabase() {

 abstract fun stockDao():StockDao
}