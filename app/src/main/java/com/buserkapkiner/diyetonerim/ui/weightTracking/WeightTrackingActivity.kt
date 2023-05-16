package com.buserkapkiner.diyetonerim.ui.weightTracking

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityWeightTrackingBinding

class WeightTrackingActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeightTrackingBinding
    private var currentWeight = 0.0
    private var goalWeight = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightTrackingBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnSaveCurrentWeight.setOnClickListener {
            currentWeight = binding.edtTxtCurrentWeight.text.toString().toDouble()
            Toast.makeText(this, "Mevcut kilonuz kaydedildi", Toast.LENGTH_SHORT).show()

        }
        setContentView(binding.root)
        binding.btnSaveGoalWeight.setOnClickListener {
          goalWeight = binding.edtTxtGoalWeight.text.toString().toDouble()
            Toast.makeText(this, "Hedef kilonuz kaydedildi", Toast.LENGTH_SHORT).show()

        }





        binding.btnShowWeightTracking.setOnClickListener {
            val weightDifference = currentWeight - goalWeight
            val message = if (weightDifference > 0) {
                "Hedef kilonuza ulaşmak için ${"%.1f".format(weightDifference)} kilo vermeniz gerekiyor."
            } else if (weightDifference < 0) {
                "Hedef kilonuza ulaşmak için ${"%.1f".format(-weightDifference)} kilo almanız gerekiyor."
            } else {
                "Tebrikler, hedef kilonuza ulaştınız!"
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}







