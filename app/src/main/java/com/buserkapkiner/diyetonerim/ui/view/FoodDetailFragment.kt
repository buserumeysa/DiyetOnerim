package com.buserkapkiner.diyetonerim.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentFoodDetailBinding
import com.buserkapkiner.diyetonerim.ui.viewmodel.FoodDetailViewModel


class FoodDetailFragment : Fragment() {
    private lateinit var viewModel: FoodDetailViewModel
    // View Binding
    private var _binding: FragmentFoodDetailBinding? = null
    private val binding get() = _binding!!
    private var foodId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            foodId= FoodDetailFragmentArgs.fromBundle(it).foodId
            println(foodId)
        }
        viewModel=ViewModelProvider(this).get(FoodDetailViewModel::class.java)
        viewModel.roomGetData()
        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.foodLiveData.observe(viewLifecycleOwner, Observer {food->
            food?.let {
                binding.txtDetailFoodName.text = it.isim
                binding.txtDetailFoodCalorie.text = it.kalori
                binding.txtDetailFoodCarbohidrates.text = it.karbonhidrat
                binding.txtDetailFoodProtein.text = it.protein
                binding.txtDetailFoodFat.text = it.yag
            }
        })
    }


}