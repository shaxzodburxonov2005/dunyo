package com.example.botk_name.Fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.botk_name.Adapter.MyAdapter
import com.example.botk_name.Adapter.SpinnerAdapter
import com.example.botk_name.AppDatabase
import com.example.botk_name.NeweDao.NeweDao
import com.example.botk_name.News
import com.example.botk_name.R
import com.example.botk_name.databinding.FragmentTwoBinding
import com.example.botk_name.databinding.ItemChangeDialogBinding
import com.example.botk_name.databinding.ItemDeleteBinding


class TwoFragment : Fragment() {
    lateinit var binding:FragmentTwoBinding
    lateinit var adapeter: MyAdapter
    lateinit var list: ArrayList<News>
    lateinit var appDatabase: AppDatabase
    lateinit var listString: ArrayList<String>
    lateinit var spinnerAdapter: SpinnerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_two, container, false)
       /*
       binding= FragmentTwoBinding.bind(view)

        appDatabase = AppDatabase.getInstance(requireContext())
        val newsdao : NeweDao = appDatabase.newsDao()

        list = ArrayList()
        list.addAll(appDatabase.newsDao().getAllNews())

        val listMain = list.filter {
            it.typeNews == "Dunyo"
        } as ArrayList<News>

        adapeter = MyAdapter(requireContext(), listMain, object : MyAdapter.ClickListener {
            override fun rootClick(news: News, position: Int) {
                val bundle=Bundle().apply {
                    putSerializable("Asosiy",news)
                }
                findNavController().navigate(R.id.aboutNewsFragment,bundle)
            }

            override fun popbar(news: News, position: Int, view: View) {
                val popupMenus = PopupMenu(context, view)
                popupMenus.inflate(R.menu.popupmenu_item)
                popupMenus.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.item1 -> {
                            val alert1 = AlertDialog.Builder(requireContext()).create()
                            val dialogview1=layoutInflater.inflate(R.layout.item_change_dialog,binding.root,false)
                            alert1.setView(dialogview1)
                            alert1.show()
                            val bind= ItemChangeDialogBinding.bind(dialogview1)
                            spinnerAdapter = SpinnerAdapter(load(), requireContext())
                            bind.spinerChange.adapter = spinnerAdapter

                            bind.matnChange.setText(news.name)
                            bind.sarlavhaChange.setText(news.info)

                            bind.SaqlashChange.setOnClickListener {
                                val name=bind.matnChange.text.toString()
                                val info=bind.sarlavhaChange.text.toString()

                                val a = resources.getStringArray(R.array.array_spiner)
                                val c = a[bind.spinerChange.selectedItemPosition]

                                news.name = name
                                news.info = info
                                news.typeNews = c

                                val news = News(name,info,c)
                                list[position] = news
                                newsdao.update(news)

                                Toast.makeText(
                                    requireContext(),
                                    "Malumot uzgartirildi",
                                    Toast.LENGTH_SHORT
                                ).show()

                                alert1.dismiss()



                            }
                            true
                        }
                        R.id.item_2 -> {
                            val alert2= AlertDialog.Builder(requireContext()).create()
                            val dialogview2=layoutInflater.inflate(R.layout.item_delete,binding.root,false)
                            alert2.setView(dialogview2)
                            alert2.show()
                            val bind2= ItemDeleteBinding.bind(dialogview2)
                            bind2.deleteSaqlash.setOnClickListener {
                                listMain.remove(news)
                                newsdao.deleteNews(news)
                                adapeter.notifyItemRemoved(position)
                                adapeter.notifyItemRangeChanged(position,listMain.size)
                                alert2.dismiss()
                            }
                            bind2.deleteBekorQilish.setOnClickListener {
                                alert2.dismiss()
                            }
                            true
                        }
                        else -> true
                    }
                }
                popupMenus.show()
            }
        })
        binding.rvTwo.adapter = adapeter*/


        return view
    }
    private fun load(): ArrayList<String> {
        listString = ArrayList()
        listString.add("Asosiy")
        listString.add("Dunyo")
        listString.add("Ijtimoiy")
        return listString
    }
}