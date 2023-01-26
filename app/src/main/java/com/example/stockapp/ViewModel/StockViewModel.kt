package com.example.stockapp.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Database.StockEvent
import com.example.stockapp.Database.StockState
import com.example.stockapp.Repository.StockRepository
import com.example.stockapp.Repository.StockRepositoryList
import com.google.android.gms.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class StockViewModel @Inject constructor(val stockRepository: StockRepository): ViewModel(){


        val stockData = MutableStateFlow(StockEntity(stockLocation = "", stockName = "", barcode = ""))
        val state: StateFlow<StockEntity> = stockData.asStateFlow()

init {

    viewModelScope.launch(Dispatchers.IO){

        stockRepository.insertStock(stockData.value)

    }



}

  fun onEvent(event: StockEvent)
  {
      when(event){
          is StockEvent.DeleteStock ->{
              viewModelScope.launch {
                  stockRepository.deleteStock(event.stockEntity)
              }
          }
          is StockEvent.InsertStock ->{
              viewModelScope.launch{
                  stockRepository.insertStock(event.stockEntity)
              }
          }
      }
  }

    fun deleteStock (stockEntity: StockEntity) = viewModelScope.launch{

        stockRepository.deleteStock(stockEntity)
    }

    fun updateStock(stockEntity: StockEntity) = viewModelScope.launch{

        stockRepository.UpdateStock(stockEntity)
    }

   fun getStock():Flow<List<StockEntity>> = stockRepository.getStock()




}