package com.example.stockapp.AppModule

import android.content.Context
import com.example.stockapp.Application.ApplicationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun toApp(@ApplicationContext app: Context):ApplicationClass{
        return app as ApplicationClass
    }
}