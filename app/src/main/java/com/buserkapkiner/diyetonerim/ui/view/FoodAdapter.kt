package com.buserkapkiner.diyetonerim.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FoodRecyclerviewRowBinding
import com.buserkapkiner.diyetonerim.ui.model.Food

class FoodAdapter (val foodList :ArrayList<Food>):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    class FoodViewHolder(var view: FoodRecyclerviewRowBinding) : RecyclerView.ViewHolder(view.root) {
        val txtFoodName: TextView
        val txtFoodCalorie: TextView

        init {
// Define click listener for the ViewHolder's View
            txtFoodName = itemView.findViewById(R.id.txt_food_name)
            txtFoodCalorie = itemView.findViewById(R.id.txt_food_calorie)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<FoodRecyclerviewRowBinding>(inflater,R.layout.food_recyclerview_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.view.food = foodList[position]

        /* holder.txtFoodName.text = foodList[position].isim.toString()
        holder.txtFoodCalorie.text = foodList[position].kalori.toString()
}*/
        holder.itemView.setOnClickListener {
            val action = FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(foodList.get(position).uuid)
            Navigation.findNavController(it).navigate(action)

//holder.view.imgFood.pictureInstall(foodList.get(position).gorsel, placeholderCreate(holder.itemView.context))
        }
    }
    fun updateFoodList(newFoodList: List<Food>) {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()

    }
}