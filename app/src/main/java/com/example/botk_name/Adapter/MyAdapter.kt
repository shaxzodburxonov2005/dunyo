package com.example.botk_name.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.botk_name.News
import com.example.botk_name.R
import com.example.botk_name.databinding.ItemViewBinding

class MyAdapter(
    var context: Context,
    var arrayList: ArrayList<News>,
    var clickListener: ClickListener
) : RecyclerView.Adapter<MyAdapter.MyvievHolder>() {
    inner class MyvievHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(news: News, position: Int) {
            val bind = ItemViewBinding.bind(itemView)
            bind.tvName.text = news.name
            bind.tvInfo.text = news.info
            bind.parent.setOnClickListener {
                clickListener.rootClick(news, position)
            }
            bind.img.setOnClickListener {
                clickListener.popbar(news, position, it)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyvievHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyvievHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyvievHolder, position: Int) {
        holder.onbind(arrayList[position], position)
    }

    interface ClickListener {
        fun rootClick(news: News, position: Int)
        fun popbar(news: News, position: Int, view: View)

    }

}