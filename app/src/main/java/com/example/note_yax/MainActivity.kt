package com.example.note_yax

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title.*
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        //同来设置 拖拽移动，或移动删除
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val swiped = ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            var dragFlags = 0
            dragFlags = if (recyclerView.layoutManager is GridLayoutManager) {
                ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            } else {
                ItemTouchHelper.UP or ItemTouchHelper.DOWN
            }
            //第一个参数拖动，第二个删除侧滑
            //第一个参数拖动，第二个删除侧滑
            return makeMovementFlags(dragFlags, swiped)
        }

        //在拖动中不断的回调这个方法
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val oldPosition = viewHolder.adapterPosition
            val newPosition = target.adapterPosition
            if (oldPosition < newPosition) {
                for (i in oldPosition until newPosition) {
                    // 改变实际的数据集
                    Collections.swap(Data.getThingList(), i, i + 1)
                }
            } else {
                for (i in oldPosition downTo newPosition + 1) {
                    // 改变实际的数据集
                    Collections.swap(Data.getThingList(), i, i - 1)
                }
            }
            adapter.notifyItemMoved(oldPosition, newPosition)
            return true
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                viewHolder?.itemView?.setBackgroundColor(Color.parseColor("#03A9F4"))
            }
        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
            super.clearView(recyclerView!!, viewHolder)
            viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

//actionState!=ItemTouchHelper.ACTION_STATE_IDLE 这句话的意思 判断 item 是否是处于闲置状态，就是有没有被你 拖动，侧滑。

        //处理侧滑
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            Data.remove(position)
            adapter.thingList = Data.getThingList()
            adapter.notifyItemRemoved(position)
        }
    })




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
        itemTouchHelper.attachToRecyclerView(recyclerView)
        buttonAdd.setOnClickListener(this)
        buttonSort.setOnClickListener {
            adapter.thingList =Data.sort()
            adapter.notifyDataSetChanged()

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if (resultCode == RESULT_OK) {
                adapter.thingList = Data.getThingList()
                adapter.notifyDataSetChanged()
                AlertDialog.Builder(this).apply {
                    setTitle("操作信息")
                    setMessage("已新建事件")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->
                    }
                    setNegativeButton("Cancel") { dialog, which ->
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