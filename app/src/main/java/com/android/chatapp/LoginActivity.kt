package com.android.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.chatapp.databinding.ActivityLoginBinding
import com.android.chatapp.exstensions.toast
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val binding: ActivityLoginBinding by viewBinding(R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initListeners()
    }

    private fun initListeners() = with(binding) {
        btnCreateAccount.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
        btnLogin.setOnClickListener { addDataToFirestore() }
    }

    private fun addDataToFirestore() {
        val data = hashMapOf<String, Any>(
            "first_name" to "Alex",
            "last_name" to "Klassen"
        )
        FirebaseFirestore.getInstance().collection("users")
            .add(data)
            .addOnSuccessListener { toast("Data inserted") }
            .addOnFailureListener { toast(it.message.toString()) }
    }
}