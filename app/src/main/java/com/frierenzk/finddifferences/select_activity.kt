package com.frierenzk.finddifferences

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.ImageButton

class select_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_activity)

        val buttonListener = View.OnClickListener {
            var pic = ""
            when (it.id) {
                R.id.imButton1 -> pic = "env"
                R.id.imButton2 -> pic = "ani2"
                R.id.imButton3 -> pic = "hum"
                R.id.imButton4 -> pic = "ani1"
                R.id.imButton5 -> pic = "toy"
                R.id.imButton6 -> pic = "fur"
                R.id.imButton7 -> pic = "clo"
                R.id.imButton8 -> pic = "sho"
            }
            val intent = Intent(this,game::class.java).apply {
                putExtra(EXTRA_MESSAGE,pic)
            }
            startActivity(intent)
        }
        val imView1 = findViewById<ImageButton>(R.id.imButton1)
        imView1.setOnClickListener(buttonListener)
        val imView2 = findViewById<ImageButton>(R.id.imButton2)
        imView2.setOnClickListener(buttonListener)
        val imView3 = findViewById<ImageButton>(R.id.imButton3)
        imView3.setOnClickListener(buttonListener)
        val imView4 = findViewById<ImageButton>(R.id.imButton4)
        imView4.setOnClickListener(buttonListener)
        val imView5 = findViewById<ImageButton>(R.id.imButton5)
        imView5.setOnClickListener(buttonListener)
        val imView6 = findViewById<ImageButton>(R.id.imButton6)
        imView6.setOnClickListener(buttonListener)
        val imView7 = findViewById<ImageButton>(R.id.imButton7)
        imView7.setOnClickListener(buttonListener)
        val imView8 = findViewById<ImageButton>(R.id.imButton8)
        imView8.setOnClickListener(buttonListener)
    }
}
