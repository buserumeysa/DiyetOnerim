package com.buserkapkiner.diyetonerim.ui.diet

import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.databinding.CardCellBinding

class DietViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: DietClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindDiet(diet: Diet){
        cardCellBinding.imgDietPicture.setImageResource(diet.imgDietPicture)
        cardCellBinding.txtDietTitle.text = diet.txtDietTitle

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(diet)
        }
    }
}