package com.ajay.getapiwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajay.getapiwithmvvm.R
import com.ajay.getapiwithmvvm.model.GithubResponse
import com.google.android.material.textview.MaterialTextView

class GithubAdapter(private var mList: List<GithubResponse>):
    RecyclerView.Adapter<GithubAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView1.text = ItemsViewModel.title
        holder.textView.text = ItemsViewModel.created_at
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: MaterialTextView = itemView.findViewById(R.id.text_title)
        val textView: MaterialTextView = itemView.findViewById(R.id.text_date)
    }
}