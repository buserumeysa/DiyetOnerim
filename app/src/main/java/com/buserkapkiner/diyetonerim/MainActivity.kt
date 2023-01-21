package com.buserkapkiner.diyetonerim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.buserkapkiner.diyetonerim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btngiris.setOnClickListener {
            intent = Intent(applicationContext,Bki::class.java)
            startActivity(intent)
        }
        binding.btnkayit.setOnClickListener {
            intent = Intent(applicationContext,Kayit::class.java)
            startActivity(intent)
        }
    }
}