package com.buserkapkiner.diyetonerim.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buserkapkiner.diyetonerim.ui.model.Food
import com.buserkapkiner.diyetonerim.ui.service.FoodAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FoodListViewModel:ViewModel() {
    val foods =MutableLiveData<List<Food>>()
    val foodsErrorMessage=MutableLiveData<Boolean>()
    val foodsLoading=MutableLiveData<Boolean>()


    private val foodApiService =FoodAPIService()
    private val disposable = CompositeDisposable()//kullan at
    fun refresData(){
        getDataFromTheInternet()

    }
    private fun getDataFromTheInternet(){
        foodsLoading.value=true

        disposable.add(
            foodApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Food>>(){
                    override fun onSuccess(t: List<Food>) {
                        //Başarılı olursa
                        foods.value = t
                        foodsErrorMessage.value= false
                        foodsLoading.value= false

                    }

                    override fun onError(e: Throwable) {
                        //hata alınırsa

                        foodsErrorMessage.value=true
                        foodsLoading.value=false
                        e.printStackTrace()
                    }

                })
        )
    }

}