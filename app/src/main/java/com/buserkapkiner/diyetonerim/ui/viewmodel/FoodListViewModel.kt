package com.buserkapkiner.diyetonerim.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buserkapkiner.diyetonerim.ui.model.Food

class FoodListViewModel:ViewModel() {
    val foods =MutableLiveData<List<Food>>()
    val foodsErrorMessage=MutableLiveData<Boolean>()
    val foodsLoading=MutableLiveData<Boolean>()

    fun refresData(){
        val muz =Food("muz","20","3","3","2","aktins.jpeg")
        val erik =Food("erik","10","2","2","3","aktins.jpeg")
        val elma =Food("elma","15","1","1","4","aktins.jpeg")
        val foodList= arrayListOf<Food>(muz,erik,elma)
        foods.value=foodList
        foodsLoading.value=false
        foodsErrorMessage.value=true
    }

}