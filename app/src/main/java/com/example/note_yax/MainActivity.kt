package com.example.note_yax

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//隐藏原标题框
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        Data.init()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = MainAdapter(Data.getThingList())
        recyclerView.adapter = adapter
        buttonAdd.setOnClickListener(this)



    }


    override fun onClick(v: View?) {
        when(v){
            buttonAdd -> {
                val intentAdd = Intent(this, ThingActivity::class.java)
                startActivityForResult(intentAdd, 1)

            }
        }
    }
}