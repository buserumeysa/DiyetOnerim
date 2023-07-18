package com.buserkapkiner.diyetonerim.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentLoginBinding
import com.buserkapkiner.diyetonerim.ui.homepage.HomePageActivity
import com.buserkapkiner.diyetonerim.ui.register.RegisterFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment(R.layout.fragment_login) {

    // SharedPreferences anahtarları
    private val PREF_EMAIL = "email"
    private val PREF_PASSWORD = "password"

    // Firebase kimlik doğrulama
    private val auth = Firebase.auth

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kaydedilmiş e-posta ve şifre değerlerini al
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
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
        val registerFragment = RegisterFragment()

        binding.btnRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)


        }


    }


    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Giriş başarılı olduğunda kaydet
                    saveCredentials(email, password)

                    Toast.makeText(
                        requireContext(),
                        "HOŞGELDİNİZ",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(requireContext(), HomePageActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Giriş Yapılamadı, Lütfen e-mail adresini doğru girdiğinizden emin olun.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    private fun saveCredentials(email: String, password: String) {
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(PREF_EMAIL, email)
        editor.putString(PREF_PASSWORD, password)
        editor.apply()
    }



}