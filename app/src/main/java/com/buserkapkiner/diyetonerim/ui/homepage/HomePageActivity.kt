package com.buserkapkiner.diyetonerim.ui.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buserkapkiner.diyetonerim.R
import kotlinx.android.synthetic.main.activty_home_page.*

class HomePageActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_home_page)

        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter


    }


}