package com.ajay.getapiwithmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajay.getapiwithmvvm.model.GithubResponse
import com.ajay.getapiwithmvvm.network.RetrofitInstance
import com.ajay.getapiwithmvvm.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubViewModel: ViewModel() {


    var gitHubDataList = MutableLiveData<List<GithubResponse>>()

    fun getApiData(){
        /*val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)*/
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitInstance.getDataFromApi().enqueue(object : Callback<List<GithubResponse>> {
            override fun onResponse(
                call: Call<List<GithubResponse>>,
                response: Response<List<GithubResponse>>
            ) {
                gitHubDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {

            }

        })

    }
}