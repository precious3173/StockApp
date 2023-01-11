package com.example.stockapp.Repository

import com.example.stockapp.Database.StockEntity
import kotlinx.coroutines.flow.Flow

class StockRepositoryList (): StockRepository {
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