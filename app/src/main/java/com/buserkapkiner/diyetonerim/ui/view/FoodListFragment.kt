package com.buserkapkiner.diyetonerim.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentFoodListBinding
import com.buserkapkiner.diyetonerim.ui.viewmodel.FoodListViewModel


class FoodListFragment : Fragment(R.layout.fragment_food_list) {
    // View Binding
    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding!!
    val viewModel: FoodListViewModel by viewModels()

    private var foodRecyclerAdapter= FoodAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refresData()
        binding.foodListRecyclerView.adapter =foodRecyclerAdapter

        binding.swipeRefreshLayout.setOnRefreshListener{ //sayfayı yenileme
            //binding.foodListRecyclerView.visibility= View.GONE
            binding.txtErrorMessage.visibility=View.GONE
            binding.progressBarFragmentFoodList.visibility=View.VISIBLE
            viewModel.refreshFromInternet()
            binding.swipeRefreshLayout.isRefreshing =false



        }
        observeLiveData()



    }

    private fun observeLiveData(){
        viewModel.foods.observe(viewLifecycleOwner, Observer {foods->
            foods?.let {
                binding.foodListRecyclerView.visibility= View.VISIBLE
                foodRecyclerAdapter.updateFoodList(foods)

            }
        })
        viewModel.foodsErrorMessage.observe(viewLifecycleOwner,Observer{error->
            error?.let {
                if (it){
                    binding.txtErrorMessage.visibility=View.VISIBLE
                    binding.foodListRecyclerView.visibility= View.GONE
                }
                else{
                    binding.txtErrorMessage.visibility=View.GONE
                    binding.foodListRecyclerView.visibility= View.VISIBLE
                }
            }
        })
        viewModel.foodsLoading.observe(viewLifecycleOwner,Observer{loading->
            loading?.let {
                if (it){
                    binding.foodListRecyclerView.visibility= View.GONE
                    binding.txtErrorMessage.visibility=View.GONE
                    binding.progressBarFragmentFoodList.visibility=View.VISIBLE

                }
                else{
                    binding.progressBarFragmentFoodList.visibility=View.GONE
                    binding.foodListRecyclerView.visibility= View.VISIBLE

                }
            }
        })
    }



}