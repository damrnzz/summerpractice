package com.example.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsList = mutableListOf<ItemModel>()


        // Создаем 10 элементов с начальными данными
        for (i in 1..10) {
            itemsList.add(
                ItemModel(
                    imageUrl = "https://avatarko.ru/img/kartinka/33/multfilm_lyagushka_32117.jpg",
                    title = "Заголовок $i",
                    description = "Описание $i"
                )
            )
        }

        val adapter = ItemAdapter(itemsList) { item ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("imageUrl", item.imageUrl)
            intent.putExtra("title", item.title)
            intent.putExtra("description", item.description)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

