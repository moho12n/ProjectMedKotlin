package com.medecin.project


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {

    @POST("sendSMS")
    fun envoyerSMS(@Body patient: Patient) : Call<String>

    @POST("/patient/insert")

    fun addpatient(@Body patient: Patient):Call<String>
    // Call<List<Player>: une fonction callback qui retourne une liste

}
