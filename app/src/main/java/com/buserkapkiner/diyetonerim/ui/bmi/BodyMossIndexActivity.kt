package com.buserkapkiner.diyetonerim.ui.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityBodyMossIndexBinding
import com.buserkapkiner.diyetonerim.ui.dietAdvice.*

class BodyMossIndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBodyMossIndexBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBodyMossIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightpicker.minValue = 30
        binding.weightpicker.maxValue = 200
        binding.heightpicker.minValue = 100
        binding.heightpicker.maxValue = 230
        binding.weightpicker.setOnValueChangedListener { _, _, _ ->
            bmiCalculator()
        }
        binding.heightpicker.setOnValueChangedListener { _, _, _ ->
            bmiCalculator()
        }
    }

    private fun bmiCalculator() {
        val height = binding.heightpicker.value
        val doubleHeight = height.toDouble() / 100
        val weight = binding.weightpicker.value
        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)
        binding.resultsTv.text = String.format("Beden Kitle İndeksiniz: %.2f", bmi)
        binding.healthyTv.text = String.format("Sağlık Durumu: %s", healthyMessage(bmi))

        binding.btnBmiAdviceWeak.isVisible = healthyMessage(bmi) == "Zayıf"
        binding.btnBmiAdviceNormal.isVisible = healthyMessage(bmi) == "İdeal"
        binding.btnBmiAdviceFat.isVisible = healthyMessage(bmi) == "Kilolu"
        binding.btnBmiAdviceObese.isVisible = healthyMessage(bmi) == "Obez"
        binding.btnBmiAdviceMorbid.isVisible = healthyMessage(bmi) == "Morbid Obez"

        binding.btnBmiAdviceWeak.setOnClickListener {
            intent = Intent(applicationContext, DietAdviceToWeakActivity::class.java)
            startActivity(intent)
        }
        binding.btnBmiAdviceNormal.setOnClickListener {
            intent = Intent(applicationContext, DietAdviceToIdealActivity::class.java)
            startActivity(intent)
        }
        binding.btnBmiAdviceFat.setOnClickListener {
            intent = Intent(applicationContext, DietAdviceToFatActivity::class.java)
            startActivity(intent)
        }
        binding.btnBmiAdviceObese.setOnClickListener {
            intent = Intent(applicationContext, DietAdviceToObeseActivity::class.java)
            startActivity(intent)
        }

        binding.btnBmiAdviceMorbid.setOnClickListener {
            intent = Intent(applicationContext, DietAdviceToMorbidObeseActivity::class.java)
            startActivity(intent)

        }

    }

    private fun healthyMessage(bmi: Double): String {
        binding.sensor.setBackgroundColor(resources.getColor(R.color.yellow))
        if (bmi < 18.5)

            return "Zayıf"
        binding.sensor.setBackgroundColor(resources.getColor(R.color.green))
        if (bmi < 25.0)
            return "İdeal"
        binding.sensor.setBackgroundColor(resources.getColor(R.color.orange))
        if (bmi < 30.0)
            return "Kilolu"
        binding.sensor.setBackgroundColor(resources.getColor(R.color.red))
        if (bmi < 35.0)
            return "Obez"

        binding.sensor.setBackgroundColor(resources.getColor(R.color.darkRed))
        return "Morbid Obez"


    }

}