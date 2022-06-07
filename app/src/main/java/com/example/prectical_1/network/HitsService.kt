package com.example.prectical_1.network

import com.example.prectical_1.model.NetworkResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface HitsService {

    @GET("api/v1/search_by_date")
    suspend fun getHits(@Query("tags")tag:String?,@Query("page")page : Int) : NetworkResponseModel
}