package com.example.task2

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val imageView = findViewById<ImageView>(R.id.detailImage)
        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val descEditText = findViewById<EditText>(R.id.descriptionEditText)

        val imageUrl = intent.getStringExtra("imageUrl")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        Glide.with(this).load(imageUrl).into(imageView)
        titleEditText.setText(title)
        descEditText.setText(description)
    }
}
