package com.example.myredditapplication.Listener

interface OnClickListener <T> {

    fun onClick(pos: Int, detail: T?,type:Int)

    fun onItemClick(pos: Int, detail: T?)

}