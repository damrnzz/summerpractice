package com.example.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.random.Random

class ItemAdapter(
    private val items: MutableList<ItemModel>,
    private val onItemClick: (ItemModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.itemImageView)
        val titleTextView: TextView = view.findViewById(R.id.itemTitleTextView)
        val descTextView: TextView = view.findViewById(R.id.itemDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.imageView)

        holder.titleTextView.text = item.title
        holder.descTextView.text = item.description

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        holder.imageView.setOnClickListener {
            val newImageUrl = getRandomImageUrl()
            item.imageUrl = newImageUrl
            Glide.with(holder.itemView.context).load(newImageUrl).into(holder.imageView)
        }
    }

    private fun getRandomImageUrl(): String {
        val picturesList = listOf(
            "https://avatarko.ru/img/kartinka/33/multfilm_lyagushka_32117.jpg",
            "https://s3.stroi-news.ru/img/klassnie-kartinki-dlya-devochek-4.jpg",
            "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        )
        return picturesList[Random.nextInt(picturesList.size)]
    }
}
