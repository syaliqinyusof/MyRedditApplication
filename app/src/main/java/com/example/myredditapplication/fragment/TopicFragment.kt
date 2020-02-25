package com.example.myredditapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myredditapplication.R
import com.example.myredditapplication.Utils.ObjectData
import kotlinx.android.synthetic.main.fragment_full_details.*

class TopicFragment  : Fragment() {

    companion object {
        fun newInstance() = TopicFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_full_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_details.text=arguments!!.getString(ObjectData.Details)

    }

}