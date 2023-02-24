package com.example.botk_name.Adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.botk_name.Fragment.FirstFragment
import com.example.botk_name.News

class ProductAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return FirstFragment().apply {
            arguments = Bundle().apply {
                putInt("position", position)
            }
        }
    }
}