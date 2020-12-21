package com.example.note_yax

object Data {
    private val map = mutableMapOf<Int,Thing>()
    private lateinit var list: MutableList<Thing>
    private var nextId = 3


    fun init(){
        repeat(20){
            map[0 + it * 3] = Thing("2","234","12.15","12.20",6,0, 0)
            map[1 + it * 3] = Thing("3","123","12.16","12.21",6,0, 1)
            map[2 + it * 3] = Thing("4","2315","12.15","12.250",4,0,2)
        }
        list = map.values.toList() as MutableList<Thing>
    }

    fun save(){
        
    }

    fun getThing(id: Int) : Thing? {
        return map[id]
    }

    fun putThing(thing: Thing) {
        list[nextId] = thing
        map[nextId] = thing
        nextId++
    }
    fun changeThing(id: Int,thing: Thing){
        map[id] = thing
        list[id] = thing
    }

    fun getNextId():Int{
        return nextId
    }
    fun remove(position:Int){
        map.remove(position)
        list.removeAt(position)
    }
    fun getSize():Int{
        return map.size
    }
    fun sortByPriority():List<Thing>{
        return list.sortedBy {
            it.priority
        }
    }
    fun sortByDataTime():List<Thing>{
        return list.sortedBy {
            it.dataTime
        }
    }

    fun getThingList(): List<Thing> {
        return list
    }
}