package com.example.note_yax

object Data {
    val map = mutableMapOf<Int,Thing>()
    fun init(){
        map[0] = Thing("2","234","12.15","12.20",6,0, 0)
        map[1] = Thing("3","123","12.16","12.21",6,0, 1)
    }

    fun getThing(id: Int) : Thing? {
        return map[id]
    }



    fun getThingList(): List<Thing> {
        return map.values.toList();
    }
}