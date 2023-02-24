package com.example.botk_name.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.botk_name.Adapter.AdapterMain
import com.example.botk_name.Adapter.ProductAdapter
import com.example.botk_name.Adapter.SpinnerAdapter
import com.example.botk_name.AppDatabase
import com.example.botk_name.News
import com.example.botk_name.R
import com.example.botk_name.databinding.DialogBinding
import com.example.botk_name.databinding.FragmentMainBinding
import com.example.botk_name.model.User
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var adapter: ProductAdapter
    lateinit var list1: ArrayList<News>
    lateinit var list: ArrayList<Fragment>
    lateinit var listString: ArrayList<String>
    lateinit var spinnerAdapter: SpinnerAdapter
    lateinit var appDatabase: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        val actionBar = (activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.elevation = 0f
        loadfragment()

        appDatabase = AppDatabase.getInstance(requireContext())

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.add -> {
                        val alert = AlertDialog.Builder(requireContext()).create()
                        val dialogView =
                            layoutInflater.inflate(R.layout.dialog, binding.root, false)
                        alert.setView(dialogView)
                        alert.show()
                        val bind = DialogBinding.bind(dialogView)
                        spinnerAdapter = SpinnerAdapter(loadspiner(), requireContext())
                        bind.spiner.adapter = spinnerAdapter
                        bind.Saqlash.setOnClickListener {
                            val matn = bind.matn.text.toString()
                            val sarlavha = bind.salavha.text.toString()
                            val a = resources.getStringArray(R.array.array_spiner)
                            val c = a[bind.spiner.selectedItemPosition]

                            val neve = News(matn, sarlavha, c)
                            appDatabase.newsDao().addNews(neve)
                            Toast.makeText(requireContext(), "Malumot qushildi", Toast.LENGTH_SHORT)
                                .show()

//                            when (c != " "){
//                                (c == "Asosiy") -> {
//                                    val bundle = Bundle()
//                                    bundle.getBoolean("name",true)
//                                    findNavController().navigate(R.id.firstFragment,bundle)
//                                }
//
//                                else -> {}
//                            }
                            Toast.makeText(
                                requireContext(),
                                "$matn,$sarlavha,$c",
                                Toast.LENGTH_SHORT
                            ).show()
                            alert.dismiss()

                        }
                        bind.bekorQilish.setOnClickListener {
                            alert.dismiss()
                        }
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        adapter = ProductAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        val tittle = arrayListOf("Asosiy", "Dunyo", "Ijtimoiy")
        TabLayoutMediator(binding.tabView, binding.viewPager) { tab, position ->
            tab.text = tittle[position]
        }.attach()

        return view
    }

    private fun loadspiner(): ArrayList<String> {
        listString = ArrayList()
        listString.add("Asosiy")
        listString.add("Dunyo")
        listString.add("Ijtimoiy")
        return listString
    }

    private fun loadfragment() {
        list = ArrayList()
        list.add(FirstFragment())
        list.add(TwoFragment())
        list.add(TrueFragment())
    }
}