package com.otsembo.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otsembo.navigationapp.databinding.FragmentListBinding

class ListFragment : Fragment(){

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // init binding
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.peopleList.adapter = PersonAdapter()

        return binding.root
    }

}