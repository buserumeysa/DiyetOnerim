package com.buserkapkiner.diyetonerim.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentFoodDetailBinding
import com.buserkapkiner.diyetonerim.ui.util.pictureInstall
import com.buserkapkiner.diyetonerim.ui.util.placeholderCreate
import com.buserkapkiner.diyetonerim.ui.viewmodel.FoodDetailViewModel


class FoodDetailFragment : Fragment() {
    private lateinit var viewModel: FoodDetailViewModel
    private lateinit var dataBinding: FragmentFoodDetailBinding
    // View Binding
    private var foodId=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_food_detail,container,false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            foodId= FoodDetailFragmentArgs.fromBundle(it).foodId
            println(foodId)
        }
        viewModel=ViewModelProvider(this).get(FoodDetailViewModel::class.java)
        viewModel.roomGetData(foodId)
        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.foodLiveData.observe(viewLifecycleOwner, Observer {food->
            food?.let {
                dataBinding.apply {
                    selectedFood=it


                    txtDetailFoodName.text = it.isim
                    txtDetailFoodCalorie.text = it.kalori
                    txtDetailFoodCarbohidrates.text = it.karbonhidrat
                    txtDetailFoodProtein.text = it.protein
                    txtDetailFoodFat.text = it.yag
                    context?.let {
                        imgDetailFood.pictureInstall(food.gorsel, placeholderCreate(it))
                    }
                }

            }
        })
    }


}