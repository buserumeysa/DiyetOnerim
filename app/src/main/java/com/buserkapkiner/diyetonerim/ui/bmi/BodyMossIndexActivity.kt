package com.buserkapkiner.diyetonerim.ui.bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityBodyMossIndexBinding
import kotlinx.android.synthetic.main.activity_body_moss_index.*

class BodyMossIndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBodyMossIndexBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBodyMossIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kilopicker.minValue = 10
        binding.kilopicker.maxValue = 200
        binding.boypicker.minValue = 100
        binding.boypicker.maxValue = 230
        binding.kilopicker.setOnValueChangedListener { _, _, _ ->
            bkiHesapla()
        }
        binding.boypicker.setOnValueChangedListener { _, _, _ ->
            bkiHesapla()
        }
    }

    private fun bkiHesapla() {
        val boy = binding.boypicker.value
        val doubleBoy = boy.toDouble() / 100
        val kilo = binding.kilopicker.value
        val bki = kilo.toDouble() / (doubleBoy * doubleBoy)
        binding.resultsTv.text = String.format("Beden Kitle İndeksiniz: %.2f", bki)
        binding.healthyTv.text = String.format("Sağlık Durumu: %s", healthyMessage(bki))
    }

    private fun healthyMessage(bki: Double): String {
        sensor.setBackgroundColor(resources.getColor(R.color.yellow))
        if (bki < 18.5)

            return "Zayıf";
        sensor.setBackgroundColor(resources.getColor(R.color.green))
        if (bki < 25.0)
            return "İdeal"
        sensor.setBackgroundColor(resources.getColor(R.color.orange))
        if (bki < 30.0)
            return "Kilolu"
        sensor.setBackgroundColor(resources.getColor(R.color.red))
        if (bki < 35.0)
            return "Obez"

        sensor.setBackgroundColor(resources.getColor(R.color.darkRed))
        return "Morbid Obez"


    }
}