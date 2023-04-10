package com.buserkapkiner.diyetonerim.ui.dietAdvice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R

class DietAdviceToFatActivity : AppCompatActivity() {
    private lateinit var dietListViewFat: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_advice_to_fat)
        dietListViewFat = findViewById(R.id.diet_list_view_fat)

        val dietItems = arrayOf(
            "\n",
            " Pazartesi:",

            " Kahvaltı: Yulaf ezmesi, süt, çilek ve ceviz",
            "Ara öğün: 1 adet elma veya 1 dilim ananas",
            "Öğle: Izgara tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "Ara öğün: 1 avuç ceviz veya badem",
            "Akşam: Fırında somon balığı, buharda pişirilmiş sebzeler ve yeşil salata",
            "\n",
            "Salı:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet portakal veya greyfurt",
            "Öğle: Kıymalı sebzeli çorba, tam buğday ekmeği",
            "Ara öğün: 1 avuç kuru kayısı veya incir",
            "Akşam: Fırında tavuk but, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Çarşamba:",

            "Kahvaltı: Yulaf ezmesi, süt, muz ve ceviz",
            "Ara öğün: 1 adet armut veya 1 dilim ananas",
            "Öğle: Fırında sebzeli tavuk, bulgur pilavı ve yeşil salata",
            "Ara öğün: 1 avuç badem veya ceviz",
            "Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Perşembe:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet elma veya 1 dilim ananas",
            "Öğle: Nohutlu mercimek çorbası, tam buğday ekmeği ve yeşil salata",
            "Ara öğün: 1 avuç kuru kayısı veya incir",
            "Akşam: Izgara tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Cuma:",

            "Kahvaltı: Yulaf ezmesi, süt, çilek ve ceviz",
            "Ara öğün: 1 adet portakal veya greyfurt",
            "Öğle: Fırında somon balığı, buharda pişirilmiş sebzeler ve yeşil salata ",
            "Ara öğün: 1 avuç badem veya ceviz",
            "Akşam: Kıymalı sebzeli çorba, tam buğday ekmeği",
            "\n",
            "Cumartesi:",

            "Kahvaltı: Tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet elma veya 1 dilim ananas",
            "Öğle: Taze yeşillikli ton balığı salatası",
            "Ara öğün: 1 avuç kuru kayısı veya incir",
            "Akşam: Fırında ızgara tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "\n",
            "Pazar:",

            "Kahvaltı: Yulaf ezmesi, süt, muz ve ceviz",
            "Ara öğün: 1 adet portakal veya greyfurt",
            "Öğle: Fırında sebzeli tavuk, bulgur pilavı ve yeşil salata",
            "Ara öğün: 1 avuç badem veya ceviz",
            "Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata",
            "\n"


        )

        val adapter = ArrayAdapter(this, R.layout.listview_items, R.id.txt_list, dietItems)
        dietListViewFat.adapter = adapter

    }
}