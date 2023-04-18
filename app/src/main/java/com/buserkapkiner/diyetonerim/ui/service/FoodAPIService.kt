package com.buserkapkiner.diyetonerim.ui.service

import com.buserkapkiner.diyetonerim.ui.model.Food
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FoodAPIService {
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti.git
// https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private fun generateOkHttpClient():OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor())
            .build()
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(generateOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FoodAPI::class.java)

    fun getData(): Single<List<Food>> {
        return api.getFood()
    }

}