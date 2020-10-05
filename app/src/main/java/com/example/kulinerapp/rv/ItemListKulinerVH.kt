package com.example.kulinerapp.rv

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ItemListFoodBinding
import com.example.kulinerapp.remote.POJO.KulinerItem
import com.google.android.material.card.MaterialCardView
import org.jetbrains.annotations.NotNull

class ItemListKulinerVH(binding: ItemListFoodBinding) : RecyclerView.ViewHolder(binding.root) {
    private val image: ImageView = binding.imageView
    private val title: TextView = binding.txtTitle
    private val date: TextView = binding.txtAlamat
    private val root: MaterialCardView = binding.root

    fun bind(kuliner: KulinerItem) {
        title.text = kuliner.nama
        date.text = kuliner.alamat
        Glide.with(root.context).load(kuliner.gambarUrl).into(image)
    }
}