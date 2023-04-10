package com.buserkapkiner.diyetonerim.ui.dietAdvice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R

class DietAdviceToObeseActivity : AppCompatActivity() {
    private lateinit var dietListViewObese: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_advice_to_obese)
        dietListViewObese = findViewById(R.id.diet_list_view_obese)

        val dietItems = arrayOf(
            "\n",
            "Pazartesi:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz ve çilek",
            "Ara öğün: 1 adet elma",
            "Öğle: Yeşillikli tavuk salatası, tam buğday ekmeği ve yoğurt",
            "Ara öğün: 1 porsiyon taze meyve salatası",
            "Akşam: Izgara balık, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Salı:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet muz",
            "Öğle: Nohutlu sebzeli mercimek çorbası ve tam buğday ekmeği",
            "Ara öğün: 1 adet portakal",
            "Akşam: Tavuk şinitzel, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Çarşamba:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz ve çilek",
            "Ara öğün: 1 adet kivi ",
            "Öğle: Ispanaklı omlet, tam buğday ekmeği ve yoğurt ",
            "Ara öğün: 1 porsiyon taze sebze salatası",
            "Akşam: Izgara tavuk, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Perşembe:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet elma",
            "Öğle: Tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "Ara öğün: 1 porsiyon taze meyve salatası",
            "Akşam: Izgara köfte, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Cuma:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz ve çilek",
            "Ara öğün: 1 adet muz",
            "Öğle: Fırında tavuk, sebzeli salata ve tam buğday ekmeği",
            "Ara öğün: 1 porsiyon taze sebze salatası",
            "Akşam: Izgara somon balığı, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Cumartesi:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet portakal",
            "Öğle: Ton balıklı yeşillik , salata, tam buğday ekmeği ve yoğurt",

            "Ara öğün: 1 adet elma",
            "Akşam: Izgara tavuk, sebzeli salata ve kahverengi pirinç",
            "\n",
            "Pazar:",

            "Kahvaltı: Yulaf ezmesi, süt, ceviz ve çilek",
            "Ara öğün: 1 porsiyon taze meyve salatası",
            "Öğle: Fırında sebzeli tavuk, tam buğday ekmeği ve yoğurt",
            "Ara öğün: 1 adet kivi",
            "Akşam: Izgara biftek, sebzeli salata ve kahverengi pirinç",
            "\n",


        )
        val adapter = ArrayAdapter(this, R.layout.listview_items, R.id.txt_list, dietItems)
        dietListViewObese.adapter = adapter
    }
}