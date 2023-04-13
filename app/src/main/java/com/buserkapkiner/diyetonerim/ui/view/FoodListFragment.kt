package com.buserkapkiner.diyetonerim.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.ui.viewmodel.FoodListViewModel


class FoodListFragment : Fragment() {
    private val viewModel: FoodListViewModel by viewModels()

    private  var foodRecyclerAdapter= FoodAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refresData()
    }



}