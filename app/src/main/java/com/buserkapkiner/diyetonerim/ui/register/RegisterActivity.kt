package com.buserkapkiner.diyetonerim.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityRegisterBinding
import com.buserkapkiner.diyetonerim.ui.login.MainActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreateAccount.setOnClickListener {

            var userName = binding.edtTxtCreateUserName.text.toString()
            var userPassword = binding.edtTxtCreatePassword.text.toString()
            var SharedPreferences = this.getSharedPreferences("Bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()
            //veri ekleme
            editor.putString("kullanıcı", "$userName").apply()
            editor.putString("kullanıcı", "$userPassword").apply()
            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.edtTxtCreateUserName.text.clear()
            binding.edtTxtCreatePassword.text.clear()
        }

        binding.btnBackToMain.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }
}