package com.example.stockapp.AppModule

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import com.example.stockapp.Database.MIGRATION_1_2
import com.example.stockapp.Database.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Volatile
    private var INSTANCE: StockDatabase? = null


     @Singleton
     @Provides
    fun getDatabase(app: Application) : StockDatabase{


        val instance = INSTANCE

        if (instance != null) return instance

        synchronized(this){

            val instanceofDatabase = Room.databaseBuilder(
                app.applicationContext, StockDatabase::class.java,
                "Stock_Database"
            ).addMigrations(MIGRATION_1_2,).allowMainThreadQueries().build()

            INSTANCE = instanceofDatabase

            return instanceofDatabase;
        }



    }

}