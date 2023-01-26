package com.example.stockapp.Database

sealed class StockEvent{

data class DeleteStock (val stockEntity: StockEntity): StockEvent()
    data class InsertStock (val stockEntity: StockEntity): StockEvent()
}
