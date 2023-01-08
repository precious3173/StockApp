package com.example.stockapp.Database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    @Insert
    suspend fun insertStock(){


    }

    @Delete
    suspend fun deleteStock(){


    }

    @Update
    suspend fun UpdateStock(){


    }

    @Query
    fun getStock(){
        Flow<StockEntity>
    }
}