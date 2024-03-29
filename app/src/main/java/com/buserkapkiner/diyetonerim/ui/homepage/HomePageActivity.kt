package com.buserkapkiner.diyetonerim.ui.homepage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityHomePageBinding
import com.buserkapkiner.diyetonerim.ui.bmi.BmiActivity
import com.buserkapkiner.diyetonerim.ui.calendar.CalendarActivity
import com.buserkapkiner.diyetonerim.ui.diet.DietActivity
import com.buserkapkiner.diyetonerim.ui.view.FoodActivity
import com.buserkapkiner.diyetonerim.ui.weightTracking.WeightTrackingActivity

class HomePageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBki.setOnClickListener {
            intent = Intent(applicationContext, BmiActivity::class.java)
            startActivity(intent)

        }
        binding.imgDiet.setOnClickListener {
            intent = Intent(applicationContext, DietActivity::class.java)
            startActivity(intent)

        }
        binding.imgCalendar.setOnClickListener {
            intent = Intent(applicationContext, CalendarActivity::class.java)
            startActivity(intent)

        }
        binding.imgWater.setOnClickListener {
            intent = Intent(applicationContext, FoodActivity::class.java)
            startActivity(intent)

        }
        binding.imgWeightTracking.setOnClickListener {
            intent = Intent(applicationContext, WeightTrackingActivity::class.java)
            startActivity(intent)

        }


    }


}




