package com.frierenzk.finddifferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.ImageView

class game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //val pic = intent.getStringExtra(EXTRA_MESSAGE)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView.setImageBitmap(null)
        imageView2.setImageBitmap(null)

        
    }
}
