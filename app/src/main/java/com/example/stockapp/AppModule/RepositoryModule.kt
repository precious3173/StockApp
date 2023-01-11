package com.example.stockapp.AppModule

import com.example.stockapp.Database.StockDao
import com.example.stockapp.Database.StockDatabase
import com.example.stockapp.Repository.StockRepository
import com.example.stockapp.Repository.StockRepositoryList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun getRepo(stockDatabase: StockDatabase): StockRepository{

        return StockRepositoryList(stockDatabase)



    }
}