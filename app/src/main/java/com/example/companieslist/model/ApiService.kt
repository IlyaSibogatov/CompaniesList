package com.example.companieslist.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("test.php")
    fun getList(): Call<CompaniesList>

    @GET("test.php?id=")
    fun getFromId(@Query("id") id: String): Call<CompanyFromId>
}