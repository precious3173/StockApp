package com.example.stockapp.Repository

import com.example.stockapp.Database.StockDatabase
import com.example.stockapp.Database.StockEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StockRepositoryList @Inject constructor (private val stockDatabase: StockDatabase): StockRepository {
    override suspend fun insertStock(stockEntity: StockEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStock(stockEntity: StockEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun UpdateStock(stockEntity: StockEntity) {
        TODO("Not yet implemented")
    }

    override fun getStock(): Flow<List<StockEntity>> {
        TODO("Not yet implemented")
    }
}