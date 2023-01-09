package com.example.stockapp.ViewModel

import com.example.stockapp.Database.StockDao
import com.example.stockapp.Database.StockEntity
import kotlinx.coroutines.flow.Flow

class StockViewModel: StockDao {
    override suspend fun insertStock(stockEntity: StockEntity) {
        super.insertStock(stockEntity)
    }

    override suspend fun deleteStock(stockEntity: StockEntity) {
        super.deleteStock(stockEntity)
    }

    override suspend fun UpdateStock(stockEntity: StockEntity) {
        super.UpdateStock(stockEntity)
    }

    override fun getStock(): Flow<List<StockEntity>> {
        TODO("Not yet implemented")
    }
}