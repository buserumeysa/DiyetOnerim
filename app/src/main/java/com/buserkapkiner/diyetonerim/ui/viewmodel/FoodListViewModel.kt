package com.buserkapkiner.diyetonerim.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.buserkapkiner.diyetonerim.ui.model.Food
import com.buserkapkiner.diyetonerim.ui.service.FoodAPIService
import com.buserkapkiner.diyetonerim.ui.service.FoodDataBase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FoodListViewModel(application: Application):BaseViewModel(application) {
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
                        saveToSql(t)

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
    private fun showFoods(foodsList: List<Food>){
        foods.value = foodsList
        foodsErrorMessage.value= false
        foodsLoading.value= false


    }
    private fun saveToSql(foodsList: List<Food>){
        launch {
            val dao=FoodDataBase(getApplication()).foodDao()
            dao.deleteAllFood()
            val uuidList = dao.insertAll(*foodsList.toTypedArray()) //listeyi tek tek dao içerisine ver
            var i=0
            while (i<foodsList.size){
                foodsList[i].uuid=uuidList[i].toInt()
                i = i+1
                showFoods(foodsList)
            }
        }

    }

}