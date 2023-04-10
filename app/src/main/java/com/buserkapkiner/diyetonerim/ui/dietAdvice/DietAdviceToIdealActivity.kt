package com.buserkapkiner.diyetonerim.ui.dietAdvice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R

class DietAdviceToIdealActivity : AppCompatActivity() {
    private lateinit var dietListViewIdeal: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_advice_to_ideal)
        dietListViewIdeal = findViewById(R.id.diet_list_view_ideal)

        val dietItems = arrayOf(
            "\n",
            " Pazartesi",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Öğle: Izgara tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            " Akşam: Fırında somon balığı, buharda pişirilmiş sebzeler ve bulgur pilavı",
            "\n",
            "Salı:  ",

            " Kahvaltı: Yulaf ezmesi, süt, ceviz, çilek ve yeşil çay ",
            "Öğle: Taze yeşillikli ton balığı salatası",
            "Akşam: Fırında tavuk but, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Çarşamba:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Öğle: Ispanaklı omlet, tam buğday ekmeği ve elma",
            "Akşam: Fırında sebzeli tavuk, bulgur pilavı ve sebzeli salata",
            "\n",
            "Perşembe:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz, muz ve yeşil çay",
            " Öğle: Nohutlu mercimek çorbası, tam buğday ekmeği ve elma",
            " Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Cuma:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Öğle: Fırında somon balığı, buharda pişirilmiş sebzeler ve kahverengi pirinç",
            "Akşam: Izgara tavuk göğsü, sebzeli makarna ve sebzeli salata",
            "\n",
            "Cumartesi:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz, çilek ve yeşil çay",
            "Öğle: Taze yeşillikli ton balığı salatası",
            "Akşam: Fırında sebzeli tavuk, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Pazar:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Öğle: Ispanaklı omlet, tam buğday ekmeği ve elma",
            "Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata",
            "\n"


        )


        val adapter = ArrayAdapter(this, R.layout.listview_items, R.id.txt_list, dietItems)
        dietListViewIdeal.adapter = adapter

    }
}