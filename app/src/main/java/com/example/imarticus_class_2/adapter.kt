package com.example.imarticus_class_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load


class adapter(private val data: List<MarsPhoto>) :RecyclerView.Adapter<adapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imageview: ImageView =view.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolder {
        val ly= LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(ly)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder , position: Int) {
        holder.imageview.load(data[position].imgsrc)
        //holder.imageview.text=data[position].img_src
    }
}