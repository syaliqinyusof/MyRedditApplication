package com.example.myredditapplication.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myredditapplication.Listener.OnClickListener
import com.example.myredditapplication.R
import com.example.myredditapplication.model.ListData
import kotlinx.android.synthetic.main.itemlist.view.*

class ItemViewHolder(var view: View):
    RecyclerView.ViewHolder(view) {

    companion object {
        fun create(parent: ViewGroup): ItemViewHolder {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)

            return ItemViewHolder(view)
        }
    }

    fun bindTo(topic: ListData, listener: OnClickListener<ListData>) {
        view.tvtotalvote.text = topic.vote.toString()
        view.tvtotalUnvote.text = topic.unvote.toString()
        view.tv_topic.text = topic.details

        view.img_voting.setOnClickListener {
            //when user vote type by 1
            listener.onClick(adapterPosition, topic,1)
        }

        view.img_unvote.setOnClickListener {//when user unvote type by 0
            listener.onClick(adapterPosition, topic,0)
        }

        view.setOnClickListener {
            listener.onItemClick(adapterPosition, topic)


        }
    }

}