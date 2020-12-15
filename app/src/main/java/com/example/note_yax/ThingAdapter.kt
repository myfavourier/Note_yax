package com.example.note_yax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThingAdapter(val thingList: List<Thing>): RecyclerView.Adapter<ThingAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val thingTitle: TextView = view.findViewById(R.id.thingTitle)
        val thingContext: TextView = view.findViewById(R.id.thingContext)
        val thingCreateTime: TextView = view.findViewById(R.id.thingCreateTime)
        val thingDateTime: TextView = view.findViewById(R.id.thingDataTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thing_item,parent,false)
        return ViewHolder(view)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thing = thingList[position]
        holder.thingTitle.text = thing.title
        holder.thingContext.text = thing.context
        holder.thingCreateTime.text = thing.createTime
        holder.thingDateTime.text = thing.dataTime
    }

    override fun getItemCount() = thingList.size


}