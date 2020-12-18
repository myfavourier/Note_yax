package com.example.note_yax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.note_yax.Data.map
import kotlinx.android.synthetic.main.activity_thing.*
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class ThingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thing)
        supportActionBar?.hide()
        var text = intent.getIntExtra("id", -1)
        editTitle.setText(map[text]?.title)
        editContext.setText(map[text]?.context)
        editCreateTime.setText(map[text]?.createTime)
        editDateTime.setText(map[text]?.dataTime)
        editPriority.setText(map[text]?.priority.toString())
        editState.setText(map[text]?.state.toString())


    }
}