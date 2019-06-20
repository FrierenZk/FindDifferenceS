package com.frierenzk.finddifferences

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val finish = View.OnClickListener {
            this.finish()
        }
        val pic = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val check = checkPos[pic]
        textView.text = "请找出${check!!.size}处不同"
        val p = Vector<Pair<Float,Float>>()
        val imClickListener = View.OnClickListener {view->
            check!!.forEach {
                if(!p.contains(it.key)) {
                    if (it.key.first - it.value <= view.x && it.key.first + it.value >= view.x && it.key.second - it.value <= view.y && it.key.second + it.value >= view.y) {
                        p.add(it.key)
                        textView.text = "请找出剩余${check!!.size-p.size}处不同"
                    }
                }
            }

            if(check!!.size ==p.size){
                button.visibility = View.VISIBLE
            }
        }
        button.visibility=View.INVISIBLE
        button.setOnClickListener(finish)
        val spic = pics[pic]
        val bmp1 = BitmapDrawable(resources,assets.open(spic!!.first))
        val bmp2 = BitmapDrawable(resources,assets.open(spic!!.second))
        imageView.setImageBitmap(bmp1.bitmap)
        imageView2.setImageBitmap(bmp2.bitmap)
        imageView.setOnClickListener(imClickListener)
        imageView.setOnClickListener(imClickListener)
    }

    private val pics = mapOf(
        Pair("env",Pair("rawtest.png","rawtest.png")),
        Pair("ani2",Pair("rawtest.png","rawtest.png")),
        Pair("hum",Pair("rawtest.png","rawtest.png")),
        Pair("ani1",Pair("rawtest.png","rawtest.png")),
        Pair("toy",Pair("rawtest.png","rawtest.png")),
        Pair("fur",Pair("rawtest.png","rawtest.png")),
        Pair("clo",Pair("rawtest.png","rawtest.png")),
        Pair("sho",Pair("rawtest.png","rawtest.png"))
    )

    private val checkPos = mapOf(
        Pair("env", mapOf(      //环境
            Pair(Pair(1f,1f),100000000000f))
        ),
        Pair("ani2", mapOf(     //动物
            Pair(Pair(1f,1f),1000000000f))
        ),
        Pair("hum", mapOf(      //人物
            Pair(Pair(1f,1f),1000000000f))
        ),
        Pair("ani1", mapOf(     //动漫
            Pair(Pair(1f,1f),100000000f))
        ),
        Pair("toy", mapOf(      //玩具
            Pair(Pair(1f,1f),1f))
        ),
        Pair("fur", mapOf(      //家具
            Pair(Pair(1f,1f),1f))
        ),
        Pair("clo", mapOf(      //衣服
            Pair(Pair(1f,1f),1f))
        ),
        Pair("sho", mapOf(      //鞋子
            Pair(Pair(1f,1f),1f)
        )
        )
    )
}
