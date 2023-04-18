package com.buserkapkiner.diyetonerim.ui.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.buserkapkiner.diyetonerim.ui.model.Food


@Database(entities = arrayOf(Food::class), version = 1)
abstract class FoodDataBase : RoomDatabase() {
    abstract fun foodDao(): FoodDataAccessObject

    //Singleton
    companion object {
        @Volatile
        private var instance: FoodDataBase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            //bu sınıftan daha önce bir nesne oluşturulduysa onu döndür , oluşturulmadıysa onu döndürme ve senkronize et
            instance ?: databaseCreate(context).also {
                instance = it
            }

        }

        private fun databaseCreate(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            FoodDataBase::class.java, "fooddatabase"
        ).build()


    }
}