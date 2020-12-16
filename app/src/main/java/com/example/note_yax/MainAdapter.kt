package com.example.note_yax

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.thing_item.view.*
import android.widget.Toast.makeText as makeText1


class MainAdapter(val thingList: List<Thing>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var dataPosition: Int = 0
        val thingTitle: TextView = view.findViewById(R.id.thingTitle)
        val thingContext: TextView = view.findViewById(R.id.thingContext)
        val thingCreateTime: TextView = view.findViewById(R.id.thingCreateTime)
        val thingDateTime: TextView = view.findViewById(R.id.thingDataTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thing_item,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.thingTitle.setOnClickListener {
            val position = viewHolder.adapterPosition
            val thing = thingList[viewHolder.dataPosition]
            Toast.makeText(parent.context,"1",Toast.LENGTH_SHORT).show()
            val intent = Intent(view.context, ThingActivity::class.java)
            intent.putExtra("data", viewHolder.thingTitle.text)
            view.context.startActivity(intent)
        }
        viewHolder.thingContext.setOnClickListener {
            val position = viewHolder.adapterPosition
            val thing = thingList[position]
            val skd =
            Toast.makeText(parent.context,"1",Toast.LENGTH_SHORT).show()
        }

        viewHolder.thingCreateTime.setOnClickListener {
            val position = viewHolder.adapterPosition
            val thing = thingList[position]
            Toast.makeText(parent.context,"1",Toast.LENGTH_SHORT).show()
        }
        viewHolder.thingDateTime.setOnClickListener {
            val position = viewHolder.adapterPosition
            val thing = thingList[position]
            Toast.makeText(parent.context,"1",Toast.LENGTH_SHORT).show()
        }
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val thing = thingList[position]
            Toast.makeText(parent.context,"1",Toast.LENGTH_SHORT).show()
        }
        return ViewHolder(view)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thing = thingList[position]
        holder.thingTitle.text = thing.title
        holder.thingContext.text = thing.context
        holder.thingCreateTime.text = thing.createTime
        holder.thingDateTime.text = thing.dataTime
         holder.dataPosition = position
    }

    override fun getItemCount() = thingList.size


}