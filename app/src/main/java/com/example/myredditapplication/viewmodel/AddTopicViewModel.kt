package com.example.myredditapplication.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.example.myredditapplication.R
import com.example.myredditapplication.Utils.SingleLiveEvent
import com.example.myredditapplication.model.ListData

class AddTopicViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    val onTopicAdd: SingleLiveEvent<View> = SingleLiveEvent()

    fun onClickCreateTopic(v: View) {
        onTopicAdd.postValue(v)
    }

    fun displayTopicArray(): List<ListData> {
        return ArrayList(list).sortedWith(compareByDescending<ListData> { it.vote })
    }

    val list = arrayListOf(
        ListData(context.resources.getString(R.string.MMA_fighter), 50),
        ListData(context.resources.getString(R.string.Trump), 22),
        ListData(context.resources.getString(R.string.moustache), 8),
        ListData(context.resources.getString(R.string.histories), 80),
        ListData(context.resources.getString(R.string.CPR), 54),
        ListData(context.resources.getString(R.string.alone), 4),
        ListData(context.resources.getString(R.string.WSOP), 11),
        ListData(context.resources.getString(R.string.poker), 30),
        ListData(context.resources.getString(R.string.Towel), 15),
        ListData(context.resources.getString(R.string.boomers), 93),


        ListData(context.resources.getString(R.string.Youth), 0),
        ListData(context.resources.getString(R.string.TIFU), 42),
        ListData(context.resources.getString(R.string.Grocery), 18),
        ListData(context.resources.getString(R.string.Airport), 10),
        ListData(context.resources.getString(R.string.Sanders), 64),
        ListData(context.resources.getString(R.string.Reddit), 41),
        ListData(context.resources.getString(R.string.Sunday), 71),
        ListData(context.resources.getString(R.string.point), 2),
        ListData(context.resources.getString(R.string.term), 15),
        ListData(context.resources.getString(R.string.marathon), 3)
    )


}
