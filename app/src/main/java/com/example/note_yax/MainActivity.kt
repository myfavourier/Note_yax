package com.example.note_yax

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//隐藏原标题框
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        Data.init()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = MainAdapter(Data.getThingList())
        recyclerView.adapter = adapter
        buttonAdd.setOnClickListener(this)



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if(resultCode == RESULT_OK){
                adapter.thingList = Data.getThingList()
                adapter.notifyDataSetChanged()
               AlertDialog.Builder(this).apply {
                   setTitle("操作信息")
                   setMessage("已新建事件")
                   setCancelable(false)
                   setPositiveButton("OK"){
                       dialog,which ->
                   }
                   setNegativeButton("Cancel"){
                       dialog,which ->
                   }
                   show()
               }

            }
        }
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