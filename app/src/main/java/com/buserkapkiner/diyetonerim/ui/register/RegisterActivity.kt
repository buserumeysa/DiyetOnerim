package com.buserkapkiner.diyetonerim.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.databinding.ActivityRegisterBinding
import com.buserkapkiner.diyetonerim.ui.login.MainActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    // Initialize Firebase Auth
    val auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreateAccount.setOnClickListener {

            var userName = binding.edtTxtCreateUserName.text.toString()
            var userPassword = binding.edtTxtCreatePassword.text.toString()
            createAccount(email = userName, password = userPassword)
            binding.edtTxtCreateUserName.text.clear()
            binding.edtTxtCreatePassword.text.clear()

        }


        binding.btnBackToMain.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }

    fun createAccount(email: String, password: String) {
        // Initialize Firebase Auth

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

    }
}