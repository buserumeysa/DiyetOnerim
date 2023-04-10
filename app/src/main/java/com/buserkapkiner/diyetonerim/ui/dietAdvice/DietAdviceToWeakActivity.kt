package com.buserkapkiner.diyetonerim.ui.dietAdvice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R

class DietAdviceToWeakActivity : AppCompatActivity() {
    private lateinit var dietListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_advice_to_weak)
        dietListView = findViewById(R.id.diet_list_view)

        val dietItems = arrayOf(
            "\n",
            "Pazartesi:",
            "Kahvaltı: Yulaf ezmesi, muz, badem sütü",
            "Ara Öğün: Elma, ceviz",
            "Öğle: Izgara tavuk, kahverengi pirinç, yeşil fasulye salatası",
            "Ara Öğün: Havuç, humus",
            "Akşam: Somon, brokoli, quinoa",
            "\n",
            "Salı:",
            "Kahvaltı: Yoğurt, çilek, granola",
            "Ara Öğün: Hindistan cevizi çubukları",
            "Öğle: Tavuklu sandviç, marul, domates",
            "Ara Öğün: Havuçlu kek",
            "Akşam: Kırmızı biberli biftek, ıspanak, patates püresi",
            "\n",
            "Çarşamba:",
            "Kahvaltı: Yumurta, tam buğday ekmeği, avokado",
            "Ara Öğün: Muz, badem ezmesi",
            "Öğle: Kuru fasulye, esmer pirinç, salata",
            "Ara Öğün: Kuru kayısı",
            "Akşam: Izgara balık, brokoli, kahverengi pirinç",
            "\n",
            "Perşembe:",
            "Kahvaltı: Yulaf ezmesi, ahududu, badem sütü",
            "Ara Öğün: Greyfurt, badem",
            "Öğle: Tavuklu makarna salatası",
            "Ara Öğün: Smoothie (muz, çilek, badem sütü)",
            "Akşam: Izgara biftek, ıspanak, tatlı patates",
            "\n",
            "Cuma:",
            "Kahvaltı: Yoğurt, muz, badem, chia tohumu",
            "Ara Öğün: Çilekli dondurma",
            "Öğle: Izgara tavuk, tatlı patates, salata",
            "Ara Öğün: Tam buğday kraker, humus",
            "Akşam: Izgara balık, quinoa, brokoli",
            "\n",
            "Cumartesi:",
            "Kahvaltı: Yumurta, avokado, tam buğday ekmeği",
            "Ara Öğün: Kuru incir, badem",
            "Öğle: Tavuklu sandviç, marul, domates",
            "Ara Öğün: Kuru kayısı",
            "Akşam: Izgara biftek, kahverengi pirinç, salata",
            "\n",
            "Pazar:",
            "Kahvaltı: Yulaf ezmesi, muz, badem sütü",
            "Ara Öğün: Elma, badem ezmesi",
            "Öğle: Fırında tavuk, kahverengi pirinç, yeşil fasulye",
            "Ara Öğün: Yoğurtlu meyve salatası",
            "Akşam: Izgara somon, brokoli, kahverengi pirinç"
        )

        val adapter = ArrayAdapter(this, R.layout.listview_items,R.id.txt_list, dietItems)
        dietListView.adapter = adapter

    }
}