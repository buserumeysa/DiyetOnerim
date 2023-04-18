package com.buserkapkiner.diyetonerim.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}