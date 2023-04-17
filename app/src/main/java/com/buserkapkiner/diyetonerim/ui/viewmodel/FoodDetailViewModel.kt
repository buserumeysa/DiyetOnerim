package com.buserkapkiner.diyetonerim.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buserkapkiner.diyetonerim.ui.model.Food

class FoodDetailViewModel: ViewModel() {
    val foodLiveData=MutableLiveData<Food>()

    fun roomGetData(){
        val muz =Food("muz","20","3","3","2","aktins.jpeg")
        foodLiveData.value=muz
    }
}