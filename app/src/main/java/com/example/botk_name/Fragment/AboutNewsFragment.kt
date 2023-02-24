package com.example.botk_name.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.botk_name.News
import com.example.botk_name.R
import com.example.botk_name.databinding.FragmentAboutNewsBinding

class AboutNewsFragment : Fragment() {
    lateinit var binding: FragmentAboutNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        setHasOptionsMenu(true)
//        val actionBar = (activity as AppCompatActivity?)!!.supportActionBar
//        actionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
//        actionBar?.setDisplayHomeAsUpEnabled(true)
        val toolBar = requireActivity().findViewById<Toolbar>(R.id.topAppBar)
        toolBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        toolBar.menu.findItem(R.id.add).isVisible = true


        val view = inflater.inflate(R.layout.fragment_about_news, container, false)
        binding = FragmentAboutNewsBinding.bind(view)
        val post = arguments?.getSerializable("Asosiy") as News
        binding.aboutnews1.text = post.name
        binding.aboutnews2.text = post.info


        return view
    }

//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        item.itemId
//        return true
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        val item: MenuItem = menu.findItem(R.id.add)
//        item.isVisible = false
//        super.onPrepareOptionsMenu(menu)
//    }


}