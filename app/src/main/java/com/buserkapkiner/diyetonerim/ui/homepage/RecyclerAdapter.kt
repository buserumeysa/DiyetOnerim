package com.buserkapkiner.diyetonerim.ui.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titles = arrayOf("Beden Kitle İndeksi","Diyetler Hakkında Bilgi","Takvim","Kilo Takibi","Su Takibi")
    private var images = intArrayOf(R.drawable.bki,R.drawable.diyet,R.drawable.takvim,R.drawable.tart,R.drawable.su)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.activity_home_page,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemImage.setImageResource(images[position])

    }



    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemImage: ImageView


        init {
            itemImage=itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.item_title)
        }


    }


}