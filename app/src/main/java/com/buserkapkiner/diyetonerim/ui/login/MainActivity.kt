package com.buserkapkiner.diyetonerim.ui.login
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.ActivityMainBinding
import com.buserkapkiner.diyetonerim.ui.bmi.BodyMossIndexActivity
import com.buserkapkiner.diyetonerim.ui.register.RegisterActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val auth = Firebase.auth
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val userPassword = findViewById<EditText>(R.id.edt_txt_password)
        userPassword.setAutofillHints(View.AUTOFILL_HINT_PASSWORD)
        val userName= findViewById<EditText>(R.id.edt_txt_user_name)
        userName.setAutofillHints(View.AUTOFILL_HINT_USERNAME)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var userName = binding.edtTxtUserName.text.toString()
            var userPassword = binding.edtTxtPassword.text.toString()
            login(email = userName, password = userPassword)
        }
        binding.btnRegister.setOnClickListener {
            intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }



    }



    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    intent = Intent(applicationContext, BodyMossIndexActivity::class.java)
                    startActivity(intent)


                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Giriş Yapılamadı, Lütfen e-mail adresini doğru girdiğinizden emin olun.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}