package com.example.stockapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Repository.StockRepository
import com.example.stockapp.Repository.StockRepositoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(val stockRepository: StockRepository): ViewModel(){

    val stockData = MutableLiveData<List<StockEntity>>()

    fun insertStock(stockEntity: StockEntity) = viewModelScope.launch{

        stockRepository.insertStock(stockEntity)
    }

    fun deleteStock (stockEntity: StockEntity) = viewModelScope.launch{

        stockRepository.deleteStock(stockEntity)
    }

    fun updateStock(stockEntity: StockEntity) = viewModelScope.launch{

        stockRepository.UpdateStock(stockEntity)
    }

   fun getStock():Flow<List<StockEntity>> = stockRepository.getStock()




}