package com.example.botk_name

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.botk_name.Adapter.ProductAdapter
import com.example.botk_name.Fragment.FirstFragment
import com.example.botk_name.Fragment.TrueFragment
import com.example.botk_name.Fragment.TwoFragment
import com.example.botk_name.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list1: ArrayList<News>
    lateinit var appDatabase: AppDatabase
    lateinit var list: ArrayList<Fragment>
    lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add -> {
                    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        binding.topAppBar.navigationIcon = null
        //  loadFragments()
//
//        appDatabase = AppDatabase.getInstance(this)
//        list1 = ArrayList()
//        list1.addAll(appDatabase.newsDao().getAllNews())

//        binding.add.setOnClickListener {
//            val customDialog = AlertDialog.Builder(this).create()
//            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            customDialog.setCancelable(true)
//            val dialogview = LayoutInflater.from(this).inflate(R.layout.item, binding.root, false)
//            customDialog.setView(dialogview)
//            val bind = ItemBinding.bind(dialogview)
//            bind.botomSave.setOnClickListener {
//                val name = bind.etName.text
//                val info = bind.etNumber.text
//                val neve = News(name.toString(), info.toString())
//                appDatabase.newsDao().addNews(neve)
//                Toast.makeText(this, "Malumot qushildi", Toast.LENGTH_SHORT).show()
//            }
//            customDialog.show()
//        }

//        adapter = ProductAdapter(list, this)
//        binding.viewPager.adapter = adapter
//        val tittle = arrayListOf("Asosiy", "Dunyo", "Ijtimoiy")
//        TabLayoutMediator(binding.tabView, binding.viewPager) { tab, position ->
//            tab.text = tittle[position]
//        }.attach()
//    }

        //private fun loadFragments() {
        list = ArrayList()
        list.add(FirstFragment())
        list.add(TwoFragment())
        list.add(TrueFragment())
    }
}