package com.example.kulinerapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ActivityMainBinding
import com.example.kulinerapp.remote.POJO.KulinerItem
import com.example.kulinerapp.remote.RetrofitInterfaces
import com.example.kulinerapp.remote.RetrofitService
import com.example.kulinerapp.rv.ItemListKulinerAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterRV: ItemListKulinerAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = layoutInflater
        binding = ActivityMainBinding.inflate(inflater)

        setContentView(binding.root)
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Glide.with(this).load(R.drawable.kuliner1).into(binding.imgToolbar)
        adapterRV = ItemListKulinerAdapter()

        binding.rvFood.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRV


            val retrofitService = RetrofitService.buildService(RetrofitInterfaces::class.java)
            lifecycleScope.launch {
                val request = retrofitService.topHeadlines()
                if (request.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        request.body()?.kuliner.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    request.body()?.kuliner?.let { data ->

                        //buat sebuah array kosong yang hanya bisa di isi oleh ArticlesItem
                        val dataResult = arrayListOf<KulinerItem>()

                        //lakukan perulangan pada setiap item dari data
                        data.forEach { item ->
                            //jika item tidak bernilai null maka
                            item?.let {
                                //tambahkan item ke dalam dataResult
                                dataResult.add(it)
                            }
                        }
                        //masukkan dataResult ke dalam adapterRV
                        adapterRV.addData(dataResult)

                        //mengisi kekosongan headline
                        val beritaPertama = data[0]
                        binding.itemHeadline.run {
                            textTitle.text = beritaPertama?.nama
                            textDate.text = beritaPertama?.alamat
                            beritaPertama?.let {
                                Glide.with(this@MainActivity)
                                    .load(it.gambarUrl)
                                    .into(imgHeadline)
                            }
                            root.setOnClickListener {
                                val intent = Intent(it.context, DetailActivity::class.java).apply {
                                    putExtra("KULINER_ITEM", beritaPertama)
                                }
                                it.context.startActivity(intent)
                            }
                        }
                    }
                } else {
                    Log.e("OnlineActivity", request.message())
                }
            }
        }
    }
}