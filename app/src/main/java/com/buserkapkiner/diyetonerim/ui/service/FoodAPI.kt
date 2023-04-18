package com.buserkapkiner.diyetonerim.ui.service

import com.buserkapkiner.diyetonerim.ui.model.Food
import io.reactivex.Single
import retrofit2.http.GET

interface FoodAPI {
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json")
    fun getFood():Single<List<Food>>
}