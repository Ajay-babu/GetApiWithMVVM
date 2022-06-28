package com.ajay.getapiwithmvvm.network

import com.ajay.getapiwithmvvm.model.GithubResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/repos/octocat/hello-world/issues")
    fun getDataFromApi(): Call<List<GithubResponse>>
}