package com.buserkapkiner.diyetonerim.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.buserkapkiner.diyetonerim.R
import com.buserkapkiner.diyetonerim.databinding.FragmentRegisterBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment(R.layout.fragment_register) {
    // Firebase Auth nesnesini sınıf düzeyinde tanımla
    private val auth = Firebase.auth

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateAccount.setOnClickListener {
            val userName = binding.edtTxtCreateUserName.text.toString()
            val userPassword = binding.edtTxtCreatePassword.text.toString()
            createAccount(email = userName, password = userPassword)
            binding.edtTxtCreateUserName.text.clear()
            binding.edtTxtCreatePassword.text.clear()
        }

        binding.btnBackToMain.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(requireContext(), "Kayıt Yapılamadı, Lütfen e-mail adresini doğru girdiğinizden emin olun.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
