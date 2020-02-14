package com.example.cryptocoin.network

import com.example.cryptocoin.model.TopWisataResponse
import retrofit2.Response
import retrofit2.http.GET

interface RemoteService {

    @GET("/?action=findAll")
    suspend fun getPosts(): Response<TopWisataResponse>
}