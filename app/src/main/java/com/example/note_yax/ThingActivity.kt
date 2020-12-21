package com.example.note_yax

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thing.*
import java.text.SimpleDateFormat
import java.util.*

class ThingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thing)
        supportActionBar?.hide()
        var text = intent.getIntExtra("id", -1)
        editTitle.setText(Data.getThing(text)?.title)
        editContext.setText(Data.getThing(text)?.context)
        editCreateTime.setText(Data.getThing(text)?.createTime)
        editDateTime.setText(Data.getThing(text)?.dataTime)
        editPriority.setText(Data.getThing(text)?.priority.toString())
        editState.setText(Data.getThing(text)?.state.toString())
        if(editCreateTime.text.toString().isEmpty()){
            val formatter = SimpleDateFormat("YYYY-MM-dd HH:mm:ss") //设置时间格式
            formatter.timeZone = TimeZone.getTimeZone("GMT+08") //设置时区
            val curDate = Date(System.currentTimeMillis()) //获取当前时间
            val createDate = formatter.format(curDate) //格式转换
            editCreateTime.setText(createDate.toString())
        }
        buttonSave.setOnClickListener{
            val formatter = SimpleDateFormat("YYYY-MM-dd HH:mm:ss") //设置时间格式
            formatter.timeZone = TimeZone.getTimeZone("GMT+08") //设置时区
            val curDate = Date(System.currentTimeMillis()) //获取当前时间
            val createDate = formatter.format(curDate) //格式转换
            val thingAdd = Thing(editTitle.text.toString(), editContext.text.toString(),
                createDate,editDateTime.text.toString(),Integer.parseInt(editPriority.text.toString()),
                Integer.parseInt(editState.text.toString()),Data.getNextId())
            val thingChange = Thing(editTitle.text.toString(), editContext.text.toString(),
                editCreateTime.text.toString(),editDateTime.text.toString(),Integer.parseInt(editPriority.text.toString()),
                Integer.parseInt(editState.text.toString()),Data.getNextId())
            if (editCreateTime.text.toString() != createDate){
                val id = intent.getIntExtra("id",-1)
                Data.changeThing(id,thingChange)
                finish()
            }else {
                Data.putThing(thingAdd)
                val intentSave = Intent()
                intent.putExtra("data_save", 1)
                setResult(RESULT_OK, intentSave)
                finish()
            }
        }


    }
}