package com.example.note_yax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val thingList = ArrayList<Thing>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//隐藏原标题框
        initThings()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = MainAdapter(thingList)
        recyclerView.adapter = adapter
        buttonAdd.setOnClickListener(this)
    }

    private fun initThings(){
        thingList.add(Thing("1","1235165486465116512151515151515151515155","12.15","12.20",5,0))
        thingList.add(Thing("2","234","12.15","12.20",6,0))
    }

    override fun onClick(v: View?) {
        when(v){
            buttonAdd -> {
                val intent = Intent(this,ThingActivity::class.java)
                startActivity(intent)
                
            }
        }
    }
}