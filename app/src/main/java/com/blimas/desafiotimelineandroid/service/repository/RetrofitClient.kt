package com.blimas.desafiotimelineandroid.service.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){

    companion object{

        private lateinit var mRetrofit: Retrofit
        private val BASE_URL = "https://desafio-it-server.herokuapp.com/"

        fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            if (!::mRetrofit.isInitialized){
                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return mRetrofit

        }

        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }
    }
}