package com.medecin.project


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {
    // Call<List<Player>: une fonction callback qui retourne une liste


    @POST("sendSMS")
    fun envoyerSMS(@Body patient: Patient) : Call<String>

    @POST("/patient/insert")

    fun addpatient(@Body patient: Patient):Call<String>

    @GET("login/{phone}/{password}")
    fun login(@Path("phone") name:String ,@Path( "password") pass:String):Call<List<Patient>>


    @GET("getMedecin")
    fun getmedecin(): Call<List<Medecin>>
    @GET("getMedecinCommune/{commune}")
    fun getmedecinCommune(@Path ("commune") isbn:String): Call<List<Medecin>>
}
