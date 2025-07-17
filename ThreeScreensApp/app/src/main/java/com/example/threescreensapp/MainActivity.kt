package com.example.threescreensapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val picturesList = listOf(
        "https://avatarko.ru/img/kartinka/33/multfilm_lyagushka_32117.jpg",
        "https://s3.stroi-news.ru/img/klassnie-kartinki-dlya-devochek-4.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnLoadImage = findViewById<Button>(R.id.btnLoadRandomImage)
        val btnNext = findViewById<Button>(R.id.btnGoToSecondScreen)

        btnLoadImage.setOnClickListener {
            val randomIndex = Random.nextInt(0, picturesList.size)
            val imageUrl = picturesList[randomIndex]
            Glide.with(this).load(imageUrl).into(imageView)
        }

        btnNext.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}