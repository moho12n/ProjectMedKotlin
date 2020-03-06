package com.medecin.project


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {
    // Call<List<Player>: une fonction callback qui retourne une liste
    @GET("getMedecin")
    fun getmedecin(): Call<List<Medecin>>
    @GET("getMedecinCommune/{commune}")
    fun getmedecinCommune(@Path ("commune") isbn:String): Call<List<Medecin>>
    @GET("getMedecinSpecialite/{specialite}")
    fun getmedecinSpecialite(@Path ("specialite") isbn:String): Call<List<Medecin>>
    @GET("getMedecin/{commune}/{specialite}")
    fun getMedecinSpecAndComm(@Path ("commune") isbn:String,@Path ("specialite") isbn2:String): Call<List<Medecin>>
}
