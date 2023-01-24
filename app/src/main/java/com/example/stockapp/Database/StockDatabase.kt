package com.example.stockapp.Database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameTable
import androidx.room.RoomDatabase

@Database(entities = [StockEntity::class], version = 2, exportSchema = true)
abstract class StockDatabase : RoomDatabase() {
 abstract fun stockDao():StockDao
}