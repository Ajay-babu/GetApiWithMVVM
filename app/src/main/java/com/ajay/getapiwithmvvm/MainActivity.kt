package com.ajay.getapiwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajay.getapiwithmvvm.adapter.GithubAdapter
import com.ajay.getapiwithmvvm.model.GithubResponse
import com.ajay.getapiwithmvvm.viewmodel.GithubViewModel

class MainActivity : AppCompatActivity() {
    lateinit var githubInitViewModel: GithubViewModel
   lateinit var recyclerVi : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        recyclerVi = findViewById(R.id.recyclerView)
    }

    fun loadData(){
        githubInitViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        githubInitViewModel.getApiData()
        githubInitViewModel.gitHubDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initAdapter(data:List<GithubResponse>){
        recyclerVi.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = GithubAdapter(data)
        // Setting the Adapter with the recyclerview
        recyclerVi.adapter = adapter
    }
}