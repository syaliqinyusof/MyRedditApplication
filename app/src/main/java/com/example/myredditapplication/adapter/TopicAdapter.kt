package com.example.myredditapplication.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myredditapplication.Listener.OnClickListener
import com.example.myredditapplication.holder.ItemViewHolder
import com.example.myredditapplication.model.ListData

class TopicAdapter(var dataArray: List<ListData>?, private val listener: OnClickListener<ListData>):
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)    }

    override fun getItemCount():Int {
        return dataArray?.size ?: 0
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        dataArray?.let {
            holder.bindTo(dataArray!![position],listener)
        }
    }
}