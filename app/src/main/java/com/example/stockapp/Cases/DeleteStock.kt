package com.example.stockapp.Cases

import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Repository.StockRepository
import javax.inject.Inject

class DeleteStock @Inject constructor(
    private val repository: StockRepository
) {
    suspend operator fun invoke (stockEntity: StockEntity){
        repository.deleteStock(stockEntity)
    }
}