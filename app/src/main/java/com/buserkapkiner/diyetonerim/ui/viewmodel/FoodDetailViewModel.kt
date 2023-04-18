package com.buserkapkiner.diyetonerim.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.buserkapkiner.diyetonerim.ui.model.Food
import com.buserkapkiner.diyetonerim.ui.service.FoodDataBase
import kotlinx.coroutines.launch

class FoodDetailViewModel(application: Application):BaseViewModel(application) {
    val foodLiveData = MutableLiveData<Food>()

    fun roomGetData(uuid: Int) {
        launch {
            val dao = FoodDataBase(getApplication()).foodDao()
            val food = dao.getFood(uuid)
            foodLiveData.value = food
        }

    }
}