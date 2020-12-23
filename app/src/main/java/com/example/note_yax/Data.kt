package com.example.note_yax

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object Data {

    private var map = mutableMapOf<Int,Thing>()
    private lateinit var list: MutableList<Thing>
    private var nextId = 0
    private lateinit var pref: SharedPreferences



    fun init(pref: SharedPreferences){
        this.pref = pref
        val saved = pref.getBoolean("saved", false)
        if (saved) {
            val gson = Gson()
            var idString = pref.getString("ids", "[]")
            val ids = gson.fromJson(idString, IntArray::class.java)
            for (id in ids) {
                val thingJson = pref.getString(id.toString(), "")
                map[id] = gson.fromJson(thingJson, Thing::class.java)
            }
            nextId = pref.getInt("nextID", 0)

        }
    }

    fun save() {
        val gons = Gson()
        val idsJson = gons.toJson(map.keys.toIntArray())
        val editor = pref.edit()
        editor.putString("ids", idsJson)
        editor.putInt("nextID", nextId)
        for ((key, value) in map) {
            editor.putString(key.toString(), gons.toJson(value, Thing::class.java))
        }
        editor.putBoolean("saved", true)
        editor.apply()
    }



    fun getThing(id: Int) : Thing? {
        return map[id]
    }

    fun putThing(thing: Thing) {
//        list[nextId] = thing
        map[nextId] = thing
        nextId++
        save()
    }
    fun changeThing(id: Int,thing: Thing){
        map[id] = thing
        save()
//        list[id] = thing
    }


    fun getNextId():Int{
        return nextId
    }
    fun remove(position:Int){
        map.remove(position)
        nextId--

//        list.removeAt(position)
        pref.edit().remove(position.toString())
        save()

    }
    fun sortByPriority():List<Thing>{
        list = getThingList() as MutableList<Thing>
        return list.sortedBy {
            it.priority
        }
    }
    fun sortByDataTime():List<Thing>{
        list = getThingList() as MutableList<Thing>
        return list.sortedBy {
            it.dataTime
        }
    }

    fun getThingList(): List<Thing> {
        return map.values.toList()
    }

}