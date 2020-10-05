package com.example.kulinerapp.rv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kulinerapp.DetailActivity
import com.example.kulinerapp.databinding.ItemListFoodBinding
import com.example.kulinerapp.remote.POJO.KulinerItem

class ItemListKulinerAdapter : RecyclerView.Adapter<ItemListKulinerVH>(){
    private val listKuliner = ArrayList<KulinerItem>()

    fun addData(data : List<KulinerItem>) {
        listKuliner.clear()
        listKuliner.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListKulinerVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListFoodBinding.inflate(layoutInflater,parent,false)
        return ItemListKulinerVH(binding)
    }

    override fun getItemCount(): Int {
        return listKuliner.size
    }

    override fun onBindViewHolder(holder: ItemListKulinerVH, position: Int) {
        val data = listKuliner[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context,data.title, Toast.LENGTH_SHORT).show()

            //untuk membuat intent dari recyclerview ke activity detail
            val intent = Intent(it.context,DetailActivity::class.java).apply {
                putExtra("KULINER_ITEM" , data)
            }
            it.context.startActivity(intent)

        }
    }
}