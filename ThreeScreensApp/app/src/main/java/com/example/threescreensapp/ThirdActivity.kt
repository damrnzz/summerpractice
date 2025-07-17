package com.example.threescreensapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        findViewById<TextView>(R.id.emailTextView).text = "Email: $email"
        findViewById<TextView>(R.id.passwordTextView).text = "Password: $password"
    }
}