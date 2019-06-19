package com.frierenzk.finddifferences

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.view.KeyEvent
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start)
        val startListener = View.OnClickListener {
            val intent = Intent(this,select_activity::class.java)
            startActivity(intent)
        }
        startButton.setOnClickListener(startListener)
        val exitButton = findViewById<Button>(R.id.end)
        val exitListener = View.OnClickListener {
            this.finish()
        }
        exitButton.setOnClickListener(exitListener)
    }
    private var isExit: Boolean = false

    /**
     * 双击返回键退出
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                this.finish()

            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
                isExit = true
                Handler().postDelayed(Runnable { isExit = false }, 2000)
            }
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}
