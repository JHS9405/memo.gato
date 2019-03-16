package com.example.memorama


import android.view.LayoutInflater
import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.os.Handler
import android.widget.TextView
import com.example.games.R
import kotlinx.android.synthetic.main.renglon.view.*

class MemoramaAdapter(val chips: ArrayList<Chip>, val keys: HashMap<Int,String>):


    RecyclerView.Adapter<MemoramaAdapter.ChipViewHolder>(){

    private lateinit var mHandler: Handler
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChipViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.renglon, p0, false)
        mHandler = Handler()
        return ChipViewHolder(view)

    }


    var pushedButtons: MutableList<Int> = mutableListOf<Int>()
    var score=0
    override fun getItemCount(): Int {
        return  chips.size
    }

    override fun onBindViewHolder(p0: ChipViewHolder, p1: Int) {
        p0.imageView.setImageResource(chips[p1].idImage)
        p0.imageView.id=(chips[p1].pos)
    }

    var select1: ImageView? = null
    var select2: ImageView? = null

    fun playIntent(item: ImageView){

        if(select1==null){
            select1=item
        }else if(select2==null){
            select2=item
        }


    }

    fun checkPair(item:View) {
        if(select1!=null &&select2 != null){
            if(keys[select1!!.id] == keys[select2!!.id]){
                score++
                println(score)
                pushedButtons.add(select2!!.id)
                pushedButtons.add(select1!!.id)
                select1 = null
                select2 = null
                if(score==8){
                    Toast.makeText(item.context,
                        "GANASTE", Toast.LENGTH_LONG).show()
                }
            }else {
                Handler().postDelayed({
                    select1!!.setImageResource(R.mipmap.ic_launcher)
                    select2!!.setImageResource(R.mipmap.ic_launcher)
                    select1 = null
                    select2 = null
                },500)
            }

        }

    }

    inner class ChipViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val imageView = item.findViewById<ImageView>(R.id.chip)

        init {
            item.setOnClickListener {
                if(imageView.id !in pushedButtons) {
                    when (keys[imageView.id]) {
                        "jerry" -> {
                            imageView.setImageResource(R.drawable.jerry)
                            playIntent(imageView)
                        }
                        "ahco" -> {
                            imageView.setImageResource(R.drawable.ahco)
                            playIntent(imageView)
                        }
                        "geniues" -> {
                            imageView.setImageResource(R.drawable.geniues)
                            playIntent(imageView)
                        }
                        "lomito" -> {
                            imageView.setImageResource(R.drawable.lomito)
                            playIntent(imageView)
                        }
                        "mono1" -> {
                            imageView.setImageResource(R.drawable.mono1)
                            playIntent(imageView)
                        }
                        "pepefrog" -> {
                            imageView.setImageResource(R.drawable.pepefrog)
                            playIntent(imageView)
                        }
                        "pikachu" -> {
                            imageView.setImageResource(R.drawable.pikachu)
                            playIntent(imageView)
                        }
                        "vamoacalmarno" -> {
                            imageView.setImageResource(R.drawable.vamoacalmarno)
                            playIntent(imageView)
                        }
                    }
                }
                checkPair(item)
            }
        }
    }

}
