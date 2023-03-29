package com.buserkapkiner.diyetonerim.ui.diet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityDetailBinding

class DetailActivity:AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivityDetailBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val dietID= intent.getIntExtra(DIET_ID_EXTRA,-1)
        val diet = dietFromID(dietID)
        if(diet!= null)
        {
            binding.imgDietPicture.setImageResource(diet.imgDietPicture)
            binding.txtDietDescription.text=diet.txtDietDescription
            binding.txtDietTitle.text=diet.txtDietTitle
        }
    }

    private fun dietFromID(dietID: Int): Diet? {
        for(
            diet in dietList
        )
            if (diet.id ==dietID){
                return diet
            }
            return null
    }
}