package com.example.cryptocoin.network

import com.example.cryptocoin.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RemoteConfig {

    fun makeRetrofitService(): RemoteService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(RemoteService::class.java)
    }
}