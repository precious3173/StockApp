package com.example.stockapp.Cases

import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Repository.StockRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStock @Inject constructor(
    private val repository: StockRepository
) {

    operator fun invoke(): List<StockEntity>{
        return repository.getStock()
    }


}