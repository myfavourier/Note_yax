package com.example.note_yax

object Data {
    private val map = mutableMapOf<Int,Thing>()
    private var nextId = 3

    fun init(){
        map[0] = Thing("2","234","12.15","12.20",6,0, 0)
        map[1] = Thing("3","123","12.16","12.21",6,0, 1)
        map[2] = Thing("4","2315","12.15","12.250",4,0,2)
    }

    fun getThing(id: Int) : Thing? {
        return map[id]
    }

    fun putThing(thing: Thing) {
        map[nextId] = thing
        nextId++
    }

    fun getNextId():Int{
        return nextId
    }
    fun getSize():Int{
        return map.size
    }

    fun getThingList(): List<Thing> {
        return map.values.toList();
    }
}