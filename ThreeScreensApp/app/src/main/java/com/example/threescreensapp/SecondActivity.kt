package com.example.threescreensapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val emailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.text).matches()
                val password = passwordEditText.text.toString()
                val passwordValid = password.length >= 8 &&
                        password.any { it.isDigit() } &&
                        password.any { it.isUpperCase() } &&
                        password.any { it.isLowerCase() }

                submitButton.isEnabled = emailValid && passwordValid
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        emailEditText.addTextChangedListener(watcher)
        passwordEditText.addTextChangedListener(watcher)

        submitButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("password", passwordEditText.text.toString())
            startActivity(intent)
        }
    }
}