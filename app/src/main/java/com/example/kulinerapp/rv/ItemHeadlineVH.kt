package com.example.kulinerapp.rv

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ItemHeadlineBinding
import com.example.kulinerapp.remote.POJO.KulinerItem
import com.google.android.material.card.MaterialCardView

class ItemHeadlineVH(binding: ItemHeadlineBinding) : RecyclerView.ViewHolder(binding.root) {
    private val image : ImageView = binding.imgHeadline
    private val title : TextView = binding.textTitle
    private val date : TextView = binding.textDate
    private val root : MaterialCardView = binding.root

    fun bind(kuliner : KulinerItem) {
        title.text = kuliner.nama
        date.text = kuliner.jamBukaTutup
        Glide.with(root.context).load(kuliner.gambarUrl).into(image)

    }
}