package com.buserkapkiner.diyetonerim

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.buserkapkiner.diyetonerim.databinding.ActivityKayitBinding

class Kayit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding= ActivityKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnsave.setOnClickListener {
            var kullaniciAdi = binding.kullaniciadi2.text.toString()
            var kullaniciParola = binding.sifre2.text.toString()
            var SharedPreferences =this.getSharedPreferences("Bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()
            //veri ekleme
            editor.putString("kullanıcı","$kullaniciAdi").apply()
            editor.putString("kullanıcı","$kullaniciParola").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kullaniciadi2.text.clear()
            binding.sifre2.text.clear()
        }

        binding.btnbacktomain.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }



    }
}