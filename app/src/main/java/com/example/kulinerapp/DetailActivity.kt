package com.example.kulinerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ActivityDetailBinding
import com.example.kulinerapp.remote.POJO.KulinerItem
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_list_food.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var dataIntent: KulinerItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityDetailBinding.inflate(inflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dataIntent = intent.getParcelableExtra("KULINER_ITEM") as KulinerItem
        supportActionBar?.title = dataIntent.nama
        binding.detailTitle.text = dataIntent.nama
        binding.detailAlamat.text = dataIntent.alamat
        binding.detailJambukatutup.text = dataIntent.jamBukaTutup
        binding.detailKategori.text = dataIntent.kategori
        Glide.with(this).load(dataIntent.gambarUrl).into(imgphoto)



    }
}