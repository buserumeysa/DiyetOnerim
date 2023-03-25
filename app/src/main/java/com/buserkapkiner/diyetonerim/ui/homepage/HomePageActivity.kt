package com.buserkapkiner.diyetonerim.ui.homepage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityHomePageBinding
import com.buserkapkiner.diyetonerim.ui.bmi.BodyMossIndexActivity
import com.buserkapkiner.diyetonerim.ui.calendar.CalendarActivity

class HomePageActivity : AppCompatActivity() {
    private val homePageRecyclerAdapter = RecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBki.setOnClickListener {
            intent = Intent(applicationContext, BodyMossIndexActivity::class.java)
            startActivity(intent)

        }
        binding.imgDiet.setOnClickListener {
            intent = Intent(applicationContext, BodyMossIndexActivity::class.java)
            startActivity(intent)

        }
        binding.imgCalendar.setOnClickListener {
            intent = Intent(applicationContext, CalendarActivity::class.java)
            startActivity(intent)

        }
        binding.imgWater.setOnClickListener {
            intent = Intent(applicationContext, BodyMossIndexActivity::class.java)
            startActivity(intent)

        }
        binding.imgWeightTracking.setOnClickListener {
            intent = Intent(applicationContext, BodyMossIndexActivity::class.java)
            startActivity(intent)

        }
        val recyclerView = findViewById<RecyclerView>(R.id.home_page_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = RecyclerAdapter()

        recyclerView.adapter= adapter

    }


    }





