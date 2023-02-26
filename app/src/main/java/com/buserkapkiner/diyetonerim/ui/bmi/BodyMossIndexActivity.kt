package com.buserkapkiner.diyetonerim.ui.bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityBodyMossIndexBinding
import kotlinx.android.synthetic.main.activity_body_moss_index.*
import kotlinx.coroutines.delay

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

        binding.btnBmiAdvice.isVisible = healthyMessage(bmi)!="İdeal"

    }

    private fun healthyMessage(bmi: Double): String {
        sensor.setBackgroundColor(resources.getColor(R.color.yellow))
        if (bmi < 18.5)

            return "Zayıf"
        sensor.setBackgroundColor(resources.getColor(R.color.green))
        if (bmi < 25.0)
            return "İdeal"
        sensor.setBackgroundColor(resources.getColor(R.color.orange))
        if (bmi < 30.0)
            return "Kilolu"
        sensor.setBackgroundColor(resources.getColor(R.color.red))
        if (bmi < 35.0)
            return "Obez"

        sensor.setBackgroundColor(resources.getColor(R.color.darkRed))
        return "Morbid Obez"


    }
}