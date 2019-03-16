package com.example.memorama

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama2.*

class MemoramaActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama2)
        val rv = recyclerView1
        rv.setHasFixedSize(true)
        var grid = GridLayoutManager(this, 4)
        rv.layoutManager = grid
        val memoramaKeys:HashMap<Int,String> = HashMap<Int,String>()
        val used:HashMap<String,Int> = HashMap<String,Int>()
        used.put("jerry",2)
        used.put("ahco",2)
        used.put("geniues",2)
        used.put("lomito",2)
        used.put("mono1",2)
        used.put("pepefrog",2)
        used.put("pikachu",2)
        used.put("vamoacalmarno",2)
        used.put("space",2)
        val chips = ArrayList<Chip>()
        var i=0
        loop@ while( i  < 16) {
            val rnd = (0..7).random()

            when(rnd){
                0->{
                    val temp=used["jerry"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("jerry",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "jerry"))
                    memoramaKeys[i] = "jerry"
                }
                1->{
                    val temp=used["ahco"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("ahco",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "ahco"))
                    memoramaKeys[i] = "ahco"
                }
                2->{
                    val temp=used["geniues"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("geniues",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "geniues"))
                    memoramaKeys[i] = "geniues"
                }
                3->{
                    val temp=used["lomito"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("lomito",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "lomito"))
                    memoramaKeys[i] = "lomito"
                }
                4->{
                    val temp=used["mono1"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("mono1",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "mono1"))
                    memoramaKeys[i] = "mono1"
                }
                5->{
                    val temp=used["pepefrog"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("pepefrog",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "pepefrog"))
                    memoramaKeys[i] = "pepefrog"
                }
                6->{
                    val temp=used["pikachu"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("pikachu",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "pikachu"))
                    memoramaKeys[i] = "pikachu"
                }
                7 ->{
                    val temp=used["vamoacalmarno"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("vamoacalmarno",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "vamoacalmarno"))
                    memoramaKeys[i] = "vamoacalmarno"
                }
            }
            i++
        }

        var  adapter = MemoramaAdapter(chips, memoramaKeys)
        rv.adapter = adapter

    }
}
