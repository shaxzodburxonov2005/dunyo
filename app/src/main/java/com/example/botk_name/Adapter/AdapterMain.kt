package com.example.botk_name.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.botk_name.News
import com.example.botk_name.R
import com.example.botk_name.model.User

class AdapterMain (val list:ArrayList<News>):RecyclerView.Adapter<AdapterMain.MyViewHolder>() {
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(news: News,position: Int){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        )
    }
    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position],position)
    }
}