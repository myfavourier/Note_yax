package com.example.note_yax

//定义事件类：标题，内容，创建时间，截止时间，优先级（0-10，初始化为0），状态（完成为1，未完成为0）
class Thing(val title: String,val context:String,val createTime:String,val dataTime:String,val priority:Int,val state: Int) {
    companion object{
        const val PRIORITY_INIT = 0
        const val STATE_TOBEDONE = 0
        const val STATE_DONE = 1
    }
}