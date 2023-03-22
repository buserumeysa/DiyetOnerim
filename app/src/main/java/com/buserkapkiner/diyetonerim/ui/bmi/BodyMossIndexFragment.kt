package com.buserkapkiner.diyetonerim.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentBodyMossIndexBinding
import kotlinx.android.synthetic.main.fragment_body_moss_index.*


class BodyMossIndexFragment : Fragment() {
    private lateinit var binding: FragmentBodyMossIndexBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentBodyMossIndexBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

        binding.btnBmiAdvice.isVisible = healthyMessage(bmi) != "İdeal"

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



