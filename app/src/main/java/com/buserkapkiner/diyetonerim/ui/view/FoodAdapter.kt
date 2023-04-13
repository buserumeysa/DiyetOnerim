package com.buserkapkiner.diyetonerim.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.ui.model.Food

class FoodAdapter (val foodList :ArrayList<Food>):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
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
        val view = inflater.inflate(R.layout.food_recyclerview_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.txtFoodName.text= foodList[position].toString()
        holder.txtFoodCalorie.text=foodList[position].toString()
    }
    fun updateFoodList(newFoodList:List<Food>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()

    }


}