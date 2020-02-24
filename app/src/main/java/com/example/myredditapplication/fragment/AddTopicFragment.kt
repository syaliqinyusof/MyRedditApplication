package com.example.myredditapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myredditapplication.Listener.OnClickListener
import com.example.myredditapplication.R
import com.example.myredditapplication.Utils.ObjectData
import com.example.myredditapplication.adapter.TopicAdapter
import com.example.myredditapplication.databinding.FragmentAddTopicBinding
import com.example.myredditapplication.model.ListData
import com.example.myredditapplication.viewmodel.AddTopicViewModel


class AddTopicFragment  : Fragment() {

    companion object {
        fun newInstance() = AddTopicFragment()
    }

    private lateinit var viewModel: AddTopicViewModel
    lateinit var dataBinding: FragmentAddTopicBinding
    val TopicArray: ArrayList<ListData> = ArrayList()
    lateinit var adapter: TopicAdapter
    private val VOTE = 1
    private val UNVOTE = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_topic, container, false
        )
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddTopicViewModel::class.java)
        dataBinding.viewmodel = viewModel
        dataBinding.lifecycleOwner = this

        viewModel.onTopicAdd.observe(viewLifecycleOwner, Observer {
            val intent = Intent(context, TopicFragment::class.java)
            startActivity(intent)
        })

        TopicArray.addAll(viewModel.displayTopicArray())

        adapter =
            TopicAdapter(TopicArray, object :
                OnClickListener<ListData> {
                override fun onItemClick(pos: Int, detail: ListData?) {

                    context?.let {
                        val bundle = Bundle().apply {
                            putString(ObjectData.Details, detail!!.details)
                        }
                        //navigate to the new fragment to show the topic on another fragment
//                        findNavController().navigate(R.id.action_mainFragment_to_descriptionFragment, bundle)
                    }

                }

                override fun onClick(pos: Int, detail: ListData?, type: Int) {

                    context?.let {
                        //click upvote or downvote
                        when (type) {
                            VOTE -> {
                                TopicArray[pos].vote++
                                adapter.notifyItemChanged(pos)
                            }

                            UNVOTE -> {
                                TopicArray[pos].vote--
                                adapter.notifyItemChanged(pos)
                            }


                        }


                    }

                }
            })

        dataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        dataBinding.recyclerView.adapter = adapter
        dataBinding.recyclerView.setHasFixedSize(true)
    }



}