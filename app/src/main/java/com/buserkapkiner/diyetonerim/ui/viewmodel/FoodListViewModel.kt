package com.buserkapkiner.diyetonerim.ui.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.buserkapkiner.diyetonerim.ui.model.Food
import com.buserkapkiner.diyetonerim.ui.service.FoodAPIService
import com.buserkapkiner.diyetonerim.ui.service.FoodDataBase
import com.buserkapkiner.diyetonerim.ui.util.PrivateSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FoodListViewModel(application: Application) : BaseViewModel(application) {
    val foods = MutableLiveData<List<Food>>()
    val foodsErrorMessage = MutableLiveData<Boolean>()
    val foodsLoading = MutableLiveData<Boolean>()
    private var updateTime = 0.2 * 60 * 1000 * 1000 * 1000L


    private val foodApiService = FoodAPIService()
    private val disposable = CompositeDisposable()//kullan at
    private val privateSharedPreferences = PrivateSharedPreferences(getApplication())


    fun refresData() {

        val recordingTime = privateSharedPreferences.takeTheTime()
        if (recordingTime != null && recordingTime != 0L && System.nanoTime() - recordingTime < updateTime) {
            //Sqlite'tan çek
            getDataSQLite()
        } else {

            getDataFromTheInternet()
        }

    }
    fun refreshFromInternet(){
        getDataFromTheInternet()
    }

    private fun getDataSQLite() {
        foodsLoading.value = true

        launch {

            val foodList = FoodDataBase(getApplication()).foodDao().gelAllFoods()
            showFoods(foodList)
            Toast.makeText(getApplication(), "Besinleri Room'dan Aldık", Toast.LENGTH_LONG).show()

        }
    }

    private fun getDataFromTheInternet() {
        foodsLoading.value = true

        disposable.add(
            foodApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Food>>() {
                    override fun onSuccess(t: List<Food>) {
                        //Başarılı olursa
                        saveToSql(t)
                        Toast.makeText(getApplication(), "Besinleri Internet'ten Aldık", Toast.LENGTH_LONG).show()


                    }

                    override fun onError(e: Throwable) {
                        //hata alınırsa

                        foodsErrorMessage.value = true
                        foodsLoading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun showFoods(foodsList: List<Food>) {
        foods.value = foodsList
        foodsErrorMessage.value = false
        foodsLoading.value = false


    }

    private fun saveToSql(foodsList: List<Food>) {
        launch {
            val dao = FoodDataBase(getApplication()).foodDao()
            dao.deleteAllFood()
            val uuidList =
                dao.insertAll(*foodsList.toTypedArray()) //listeyi tek tek dao içerisine ver
            var i = 0
            while (i < foodsList.size) {
                foodsList[i].uuid = uuidList[i].toInt()
                i = i + 1

            }
            showFoods(foodsList)
        }
        privateSharedPreferences.timeToSave(System.nanoTime())
    }

}