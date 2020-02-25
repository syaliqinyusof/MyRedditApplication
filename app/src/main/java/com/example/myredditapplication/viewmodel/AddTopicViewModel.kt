package com.example.myredditapplication.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.example.myredditapplication.R
import com.example.myredditapplication.Utils.SingleLiveEvent
import com.example.myredditapplication.model.ListData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddTopicViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    val onTopicAdd: SingleLiveEvent<View> = SingleLiveEvent()
    var getDataList:String? = ""

    fun onClickCreateTopic(v: View) {
        onTopicAdd.postValue(v)
    }

    fun displayTopicArray(): List<ListData> {
        return ArrayList(list).sortedWith(compareByDescending<ListData> { it.vote })
    }

    val list = arrayListOf(
        ListData(context.resources.getString(R.string.MMA_fighter), 10,50),
        ListData(context.resources.getString(R.string.Trump), 14,22),
        ListData(context.resources.getString(R.string.moustache), 60,8),
        ListData(context.resources.getString(R.string.histories), 22,80),
        ListData(context.resources.getString(R.string.CPR), 5,54),
        ListData(context.resources.getString(R.string.alone), 8,4),
        ListData(context.resources.getString(R.string.WSOP), 22,11),
        ListData(context.resources.getString(R.string.poker), 6,30),
        ListData(context.resources.getString(R.string.Towel), 0,15),
        ListData(context.resources.getString(R.string.boomers), 26,93),


        ListData(context.resources.getString(R.string.Youth), 85,30),
        ListData(context.resources.getString(R.string.TIFU), 14,42),
        ListData(context.resources.getString(R.string.Grocery), 4,18),
        ListData(context.resources.getString(R.string.Airport), 51,10),
        ListData(context.resources.getString(R.string.Sanders), 24,64),
        ListData(context.resources.getString(R.string.Reddit), 3,41),
        ListData(context.resources.getString(R.string.Sunday), 32,71),
        ListData(context.resources.getString(R.string.point), 28,37),
        ListData(context.resources.getString(R.string.term), 40,15),
        ListData(context.resources.getString(R.string.marathon), 20,73)
    )


}
