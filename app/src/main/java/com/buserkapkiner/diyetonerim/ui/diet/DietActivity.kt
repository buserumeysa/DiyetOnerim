package com.buserkapkiner.diyetonerim.ui.diet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityDietBinding

class DietActivity : AppCompatActivity(), DietClickListener {
    private lateinit var binding: ActivityDietBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDietBinding.inflate(layoutInflater)
        setContentView(binding.root)
        diets()
        val dietActivity = this
        binding.recyclerviewDiet.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = DietAdapter(dietList, dietActivity)
        }
    }

    override fun onClick(diet: Diet) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(DIET_ID_EXTRA, diet.id)
        startActivity(intent)
    }

    private fun diets() {
        val diet1 = Diet(
            R.drawable.aktins,
            "ATKİNS DİYETİ",

            "Atkins diyetinde temel amaç karbonhidrat tüketimini en aza indirmek, bu sayede vücudun enerji olarak yağ depolarını kullanmasını sağlamaktır.Popüler protein diyetlerinin temelini oluşturan atkins diyetininde aynı zamanda yüksek miktarda yağ tüketimine de izin 	vermesidir.Atkins diyeti 2 hafta uygulanan bir beslenme programıdır. Bu zaman dilimi içerisinde hastalar istedikleri kadar saf protein 	kaynağı tüketebilir. Bu konuda Atkins diyeti, kullanıcılarına herhangi bir sınırlama getirmemiştir. Diyette en büyük sınırlama 	karbonhidratlar üzerindedir. Diyetin temel kuralı günlük günlük karbonhidrat tüketiminin 20 g üzerinde çıkamaması yönündedir. Özellikle beyaz undan yapılmış ekmek, kurabiye, makarna ile beraber pirinç tüketimi diyet boyunca tamamen yasaktır."
        )
        dietList.add(diet1)

        val diet2 = Diet(
            R.drawable.akdeniz,
            "AKDENİZ DİYETİ",
            "Akdeniz diyeti, Akdeniz havzası çevresinde gelişen eski uygarlıkların yemek kültürlerinden ismini almıştır. Yani aslında bir 	beslenme 	modelidir. Yağ alımının ana kaynağı olarak zeytinyağı düzenli olarak tüketilir. Akdeniz diyeti; bitkisel gıdalar, 	tahıllar, meyveler, 	sebzeler, baklagiller ve yağlı tohumlar tüketimine dayanır. Kırmızı et ve diğer et ürünlerinin nispeten 	sınırlı tüketimini dengelemeyi 	amaçlarken, orta düzeyde balık, deniz ürünleri ve süt ürünleri tüketilir.Bu beslenme şeklinde 	günlük alınan kalorinin %35-40’ı yağ 	kaynağı olan zeytinyağı, ceviz, fındık, badem, avokado gibi besinlerden gelmektedir."
        )
        dietList.add(diet2)

        val diet3 = Diet(
            R.drawable.vegann,
            "VEGAN DİYETİ",
            "Vegan beslenme, bal, süt ürünleri ve yumurta dahil hiçbir hayvansal gıdayı tüketmemek olarak açıklanan bir beslenme şeklidir. Vegan 	beslenmenin temelinde yatan en büyük neden hayvanlara saygıdır. Dolayısıyla vegan olan kişiler hayvansal gıdalardan alacakları besin 	öğelerini bitkisel kaynaklardan ya da diğer gıdalardan alırlar.İlk başta beslenme eksikliği gibi görünsede iyi planlanan ve temiz 	gıda kaynaklarını kullanan vegan  beslenme, oldukça sağlıklı ve insan biyolojisine uygun bir diyettir. Yeşil yapraklı sebzeler 	ağırlıklı olarak tüketilir.Karbonhidrat oranı düşük sebzeler, beslenmeye daha fazla dahil edilir."
        )
        dietList.add(diet3)


        val diet4 = Diet(
            R.drawable.vejetaryen,
            "VEJETARYEN DİYETİ",

            "Vejetaryen beslenmede diyetin temelinde kırmızı et, kümes hayvanları ve balık gibi hayvan etleri yerine tahıllar, kuru baklagiller, 	soya, sebzeler, meyveler ve yağlı tohumlar gibi bitkisel kaynaklı besinlerin tüketilmesi gelmektedir. Vejetaryen diyet, metabolizma 	için sağlıklı etkiler uyandıran bir diyettir. Başta sindirim sistemi olmak üzere vücudun bir haftalık dinlenme molası vermesi anlamına gelmektedir. Dolayısıyla kilo vermeyi sağlıklı şekilde sağlayabilmek için vejetaryen diyetin tercih edilmesi tavsiye edilmektedir"

        )
        dietList.add(diet4)

        val diet5 = Diet(
            R.drawable.paleo,
            "PALEO DİYETİ",
            "Paleo diyeti az veya hiç işlem görmemiş besinleri yemeye odaklı olan bir beslenme planıdır. Paleo Diyeti’nde Bir mağara adamı gibi 	yemek ye ve kilo ver sloganı ile zayıflanabileceği savunulmaktadır. Bu diyet sistemi yüksek protein ve yüksek lif içeriği ile 	kalori kısıtlanmadan kilo verilebileceğini vaat etmektedir. Paleo diyetinin beslenme ilkelerine göre işlenmiş hazır gıdalardan uzak durulmalı, olabildiğince doğal besinler ile beslenilmelidir. Bu beslenme planında tüketilmesi ve tüketilmemesi gereken besin grupları vardır. Protein kaynağı et ve et ürünleri serbest olarak tüketilirken süt ve süt ürünlerinin tüketilmesi yasaktır. Aynı zamanda sebze ve meyve tüketimi serbest iken tahıl grubundan olan besinlerin tüketilememesi gerekir. Paleo diyetinde bir diğer yasaklı besinler üç beyaz olarak adlandırılan tuz, şeker ve undur.  "
        )
        dietList.add(diet5)

        val diet6 = Diet(
            R.drawable.kiloal,
            "KİLO ALMA DİYETİ",
            "Her insanın vücut değerlerine göre ideal bir kiloda kalması gereklidir.Nasıl ki fazla kilo kişinin sağlığını tehlikeye atan unsurlar arasında yer alıyorsa, ideal kilodan az bir kiloya 	sahip olmak da birtakım sağlık problemlerine davet çıkarabilir.Kilo vermek gibi kilo alma konusu da düzenli ve sağlıklı beslenme ile ancak mümkündür. Ayrıca alınan kiloların kalıcı olması için yaşam şartlarının da uygun hale getirilmesi gerekir.Günde 3 ana ve 3 ara öğün olmak üzere az ama sık sık beslenilmesi gerekir.Süt, kefir gibi içeceklere kuru yemiş, meyve, bal ekleyerek yüksek kalorili 	içecekler hazırlayıp;Fındık, badem, ceviz, kaju, kuru üzüm gibi kuru yemiş ve kuru meyveleri ara öğünlerinizde tüketilmelidir."
        )
        dietList.add(diet6)


    }


}