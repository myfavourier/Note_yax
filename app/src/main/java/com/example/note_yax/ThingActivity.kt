package com.example.note_yax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_thing.*

class ThingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thing)
        supportActionBar?.hide()
        //Toast.makeText(this, intent.getIntExtra("data", 0).toString(), Toast.LENGTH_LONG).show()
        var text = intent.getStringExtra("data")
        editTitle.setText(text)
    }
}