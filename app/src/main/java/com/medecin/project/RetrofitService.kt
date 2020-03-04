package com.medecin.project


import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    var gson = GsonBuilder().setLenient().create()
    val endpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://0cb5dae4.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
            .create(Endpoint::class.java)
    }
}