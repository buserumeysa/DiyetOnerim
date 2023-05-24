package com.buserkapkiner.diyetonerim.ui.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityBmiBinding
import com.buserkapkiner.diyetonerim.ui.dietAdvice.DietAdviceToFatActivity
import com.buserkapkiner.diyetonerim.ui.dietAdvice.DietAdviceToIdealActivity
import com.buserkapkiner.diyetonerim.ui.dietAdvice.DietAdviceToMorbidObeseActivity
import com.buserkapkiner.diyetonerim.ui.dietAdvice.DietAdviceToObeseActivity
import com.buserkapkiner.diyetonerim.ui.dietAdvice.DietAdviceToWeakActivity
import org.json.JSONObject


class BmiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
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

    data class DecisionNode(
        val feature: String?,
        val threshold: Double?,
        val left: DecisionNode?,
        val right: DecisionNode?,
        val nodeClass: Int?,
    )

    fun main() {
        // JSON dosyasının içeriğini temsil edelim
        val jsonStr = """
        {
            "rules": [
                {
                    "feature": "Bki",
                    "threshold": 34.49465370178223,
                    "left": {
                        "feature": "Bki",
                        "threshold": 29.609777450561523,
                        "left": {
                            "feature": "Bki",
                            "threshold": 24.886659622192383,
                            "left": {
                                "feature": "Bki",
                                "threshold": 18.52642822265625,
                                "left": {
                                    "class": 4
                                },
                                "right": {
                                    "class": 2
                                }
                            },
                            "right": {
                                "class": 0
                            }
                        },
                        "right": {
                            "class": 3
                        }
                    },
                    "right": {
                        "class": 1
                    }
                }
            ]
        }
    """

        // JSON verisini analiz et ve karar ağacını oluştur
        val decisionTree = buildDecisionTree(JSONObject(jsonStr))

        val height = binding.heightpicker.value
        val doubleHeight = height.toDouble() / 100
        val weight = binding.weightpicker.value
        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)
        binding.resultsTv.text = String.format("Beden Kitle İndeksiniz: %.2f", bmi)
        binding.healthyTv.text = String.format("Sağlık Durumu: %s", healthyMessage(bmi))
        // Karar ağacında gezinerek sonucu bul
        val result = evaluateDecisionTree(decisionTree, bmi)
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


    fun buildDecisionTree(json: JSONObject): BmiActivity.DecisionNode? {
        val rulesArray = json.getJSONArray("rules")
        return parseDecisionNode(rulesArray.getJSONObject(0))
    }

    fun parseDecisionNode(json: JSONObject): BmiActivity.DecisionNode {
        val feature = json.optString("feature")
        val threshold = json.optDouble("threshold")
        val leftJson = json.optJSONObject("left")
        val rightJson = json.optJSONObject("right")
        val nodeClass = json.optInt("class")
        val left = if (leftJson != null) parseDecisionNode(leftJson) else null
        val right = if (rightJson != null) parseDecisionNode(rightJson) else null

        return BmiActivity.DecisionNode(feature, threshold, left, right, nodeClass)
    }

    fun evaluateDecisionTree(node: BmiActivity.DecisionNode?, bki: Double): Int? {
        if (node?.feature != null && node.threshold != null) {
            if (bki < node.threshold) {
                return evaluateDecisionTree(node.left, bki)
            } else {
                return evaluateDecisionTree(node.right, bki)
            }
        } else {
            return node?.nodeClass
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