package com.buserkapkiner.diyetonerim.ui.diet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.databinding.CardCellBinding

class DietAdapter(private val diets : List<Diet>,
                  private val clickListener: DietClickListener)
    :RecyclerView.Adapter<DietViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from,parent,false)
        return DietViewHolder(binding,clickListener)
    }

    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
       holder.bindDiet(diets[position])
    }

    override fun getItemCount(): Int = diets.size
}