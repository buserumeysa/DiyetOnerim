package com.buserkapkiner.diyetonerim.ui.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.buserkapkiner.diyetonerim.ui.model.Food
@Dao
interface FoodDataAccessObject {
    @Insert
    suspend fun insertAll(vararg food: Food):List<Long>
    //vararg-> birden fazla veya istediğimiz kadar veri almamızı sağlar
    @Query("SELECT*FROM food")
    suspend fun gelAllFoods():List<Food>
    @Query("SELECT*FROM food WHERE uuid=:foodId")
    suspend fun getFood(foodId:Int):Food
    @Query("DELETE FROM food")
    suspend fun deleteAllFood()
}