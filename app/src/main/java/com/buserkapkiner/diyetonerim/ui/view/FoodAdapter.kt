package com.buserkapkiner.diyetonerim.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FoodRecyclerviewRowBinding
import com.buserkapkiner.diyetonerim.ui.model.Food

class FoodAdapter (val foodList :ArrayList<Food>):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() ,FoodClickListener{
    class FoodViewHolder(var view: FoodRecyclerviewRowBinding): RecyclerView.ViewHolder(view.root) {




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(food_recyclerview_row,parent,false)
        val view=DataBindingUtil.inflate<FoodRecyclerviewRowBinding>(inflater,R.layout.food_recyclerview_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size }
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.view.food=foodList[position]
        holder.view.listener=this

        }

    fun updateFoodList(newFoodList:List<Food>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()

    }

    override fun foodClick(view: View) {
        val uuid = view.food_uuid.text.toString().toIntOrNull()
        uuid?.let {
            val action = FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(it)
            Navigation.findNavController(view).navigate(action)

        }

    }


}