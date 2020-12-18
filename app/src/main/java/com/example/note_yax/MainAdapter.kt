package com.example.note_yax

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MainAdapter(private val thingList: List<Thing>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: Int = 0
        val thingTitle: TextView = view.findViewById(R.id.thingTitle)
        val thingContext: TextView = view.findViewById(R.id.thingContext)
        val thingCreateTime: TextView = view.findViewById(R.id.thingCreateTime)
        val thingDateTime: TextView = view.findViewById(R.id.thingDataTime)
        val thingPriority: TextView = view.findViewById(R.id.thingPriority)
        val thingState: TextView = view.findViewById(R.id.thingState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thing_item, parent, false)
        val viewHolder = ViewHolder(view)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thing = thingList[position]
        holder.thingTitle.text = thing.title
        holder.thingContext.text = thing.context
        holder.thingCreateTime.text = thing.createTime
        holder.thingDateTime.text = thing.dataTime
        holder.thingPriority.text = thing.priority.toString()
        holder.thingState.text = thing.state.toString()
        holder.id = thing.id
        holder.itemView.setOnClickListener {
            val intentId = Intent(holder.itemView.context, ThingActivity::class.java)
            intentId.putExtra("id", thing.id)
            holder.itemView.context.startActivity(intentId)
        }
    }

    override fun getItemCount() = thingList.size


}