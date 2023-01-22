package com.example.stockapp.Database

import androidx.room.Entity
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class StockDatabaseTest {

    private lateinit var stockDao: StockDao
    private lateinit var db: StockDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, StockDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        stockDao = db.stockDao()
    }

    @After
    @kotlin.jvm.Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertData() = runBlocking {

        val entity = StockEntity(stockLocation = "Bean Location", stockName = "Beans can", barcode = "codes")

       stockDao.insertStock(entity)

        assertEquals(entity.stockLocation, "Bean Location")
    }
}