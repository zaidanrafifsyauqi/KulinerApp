package com.example.kulinerapp.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kulinerapp.databinding.ItemHeadlineBinding
import com.example.kulinerapp.remote.POJO.KulinerItem
import java.util.ArrayList

class ItemHeadlineAdapter : RecyclerView.Adapter<ItemHeadlineVH>()  {
    private val dataKuliner = ArrayList<KulinerItem>()

    fun addData(data : List<KulinerItem>) {
        dataKuliner.clear()
        dataKuliner.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeadlineVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeadlineBinding.inflate(inflater,parent,false)
        return ItemHeadlineVH(binding)
    }

    override fun getItemCount(): Int {
        return dataKuliner.size
    }

    override fun onBindViewHolder(holder: ItemHeadlineVH, position: Int) {
        val data = dataKuliner[position]
        holder.bind(data)
    }
}