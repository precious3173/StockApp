package com.example.stockapp.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.stockapp.Database.StockEntity
import com.example.stockapp.Repository.StockRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class StockViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    val repository = mockk<StockRepository>()


    lateinit var stockViewModel: StockViewModel

    @get:Rule
    val coroutineRule = CoroutineRule()

    @Before
    fun setUp() {
     stockViewModel = StockViewModel(repository)
    }

   @Test
   @kotlin.jvm.Throws(Exception::class)
   fun stockModelTesting() = runBlocking {

       val stockEntity = StockEntity(0, "FoodLocation", "Food", "122222")
       stockViewModel.insertStock(stockEntity)


       assertEquals("FoodLocation",stockEntity.stockLocation )

   }
}