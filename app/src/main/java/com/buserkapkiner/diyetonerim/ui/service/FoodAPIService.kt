package com.buserkapkiner.diyetonerim.ui.service

import com.buserkapkiner.diyetonerim.ui.model.Food
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FoodAPIService {
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti.git
    private val BASE_URL = "https://github.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FoodAPI::class.java)

    fun getData(): Single<List<Food>> {
        return api.getFood()
    }
}