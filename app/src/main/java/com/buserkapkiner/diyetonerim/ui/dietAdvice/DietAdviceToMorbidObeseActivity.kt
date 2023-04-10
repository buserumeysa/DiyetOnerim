package com.buserkapkiner.diyetonerim.ui.dietAdvice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R

class DietAdviceToMorbidObeseActivity : AppCompatActivity() {
    private lateinit var dietListViewMorbidObese: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_advice_to_morbid_obese)
        dietListViewMorbidObese = findViewById(R.id.diet_list_view_morbid_obese)

        val dietItems = arrayOf(
            "Pazartesi:",

            "Kahvaltı: 2 adet haşlanmış yumurta, 1 dilim tam buğday ekmeği, domates ve salatalık",
            "Ara öğün: 1 adet elma",
            "Öğle: Tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "Ara öğün: 1 avuç çiğ badem",
            "Akşam: Fırında somon balığı, buharda pişirilmiş sebzeler ve bulgur pilavı",
            "Salı:",

            "Kahvaltı: 1 kase yulaf ezmesi, süt, ceviz ve tarçın",
            "Ara öğün: 1 adet armut",
            "Öğle: Yeşillikli ton balığı salatası",
            "Ara öğün: 1 avuç çiğ badem",
            "Akşam: Fırında tavuk but, kahverengi pirinç ve sebzeli salata",
            "Çarşamba:",

            "Kahvaltı: 1 dilim tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet portakal",
            "Öğle: Sebzeli tavuk eti, tam buğday makarna ve sebzeli salata",
            "Ara öğün: 1 adet armut",
            "Akşam: Izgara somon balığı, buharda pişirilmiş sebzeler ve bulgur pilavı",
            "Perşembe:",

            "Kahvaltı: 1 dilim tam buğday ekmeği, 2 dilim hindi füme, domates ve yeşil çay",
            "Ara öğün: 1 adet muz",
            "Öğle: Nohutlu mercimek çorbası, tam buğday ekmeği ve elma",
            "Ara öğün: 1 avuç çiğ badem",
            "Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata",
            "Cuma:",

            "Kahvaltı: 1 kase yulaf ezmesi, süt, ceviz ve tarçın",
            "Ara öğün: 1 adet elma",
            "Öğle: Izgara tavuk göğsü, kahverengi pirinç ve sebzeli salata",
            "Ara öğün: 1 adet portakal",
            "Akşam: Fırında sebzeli tavuk, tam buğday makarna ve sebzeli salata",
            "Cumartesi:",

            "Kahvaltı: 1 dilim tam buğday ekmeği, lor peyniri, domates, salatalık ve yeşil çay",
            "Ara öğün: 1 adet muz",
            "Öğle: Yeşillikli ton balığı salatası",
            "Ara öğün: 1 adet elma",
            "Akşam: Izgara tavuk, kahverengi pirinç ve sebzeli salata",

            "Pazar:",

            "Kahvaltı: 2 adet haşlanmış yumurta, 1 dilim tam buğday ekmeği, domates ve salatalık",
            "Ara öğün: 1 adet armut",
            "Öğle: Fırında sebzeli tavuk, kahverengi pirinç ve sebzeli salata",
            "Ara öğün: 1 avuç çiğ badem",
            "Akşam: Izgara köfte, kahverengi pirinç ve sebzeli salata"


        )
        val adapter = ArrayAdapter(this, R.layout.listview_items, R.id.txt_list, dietItems)
        dietListViewMorbidObese.adapter = adapter
    }
}