package com.buserkapkiner.diyetonerim.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityMainBinding
import com.buserkapkiner.diyetonerim.ui.homepage.HomePageActivity
import com.buserkapkiner.diyetonerim.ui.register.RegisterActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {


    // SharedPreferences anahtarları
    private val PREF_EMAIL = "email"
    private val PREF_PASSWORD = "password"

    // Firebase kimlik doğrulama
    private val auth = Firebase.auth

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kaydedilmiş e-posta ve şifre değerlerini al
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val savedEmail = sharedPref.getString(PREF_EMAIL, "")
        val savedPassword = sharedPref.getString(PREF_PASSWORD, "")

        // E-posta ve şifre alanlarını otomatik doldur
        binding.edtTxtUserName.setText(savedEmail)
        binding.edtTxtPassword.setText(savedPassword)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtTxtUserName.text.toString()
            val password = binding.edtTxtPassword.text.toString()
            login(email, password)
        }



        val passwordTransformationMethod = PasswordTransformationMethod.getInstance()

        binding.edtTxtPassword.transformationMethod = passwordTransformationMethod

        binding.btnShowPassword.setOnClickListener {
            if (binding.edtTxtPassword.transformationMethod == passwordTransformationMethod) {
                binding.edtTxtPassword.transformationMethod = null
            } else {
                binding.edtTxtPassword.transformationMethod = passwordTransformationMethod
            }
        }
        binding.btnRegister.setOnClickListener {
            intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }



    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Giriş başarılı olduğunda kaydet
                    saveCredentials(email, password)

                    Toast.makeText(
                        baseContext,
                        "HOŞGELDİNİZ",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(applicationContext, HomePageActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        baseContext,
                        "Giriş Yapılamadı, Lütfen e-mail adresini doğru girdiğinizden emin olun.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    private fun saveCredentials(email: String, password: String) {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(PREF_EMAIL, email)
        editor.putString(PREF_PASSWORD, password)
        editor.apply()
    }



}