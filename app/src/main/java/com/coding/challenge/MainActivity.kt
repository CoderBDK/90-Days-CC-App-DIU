package com.coding.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// Activity-lifecycle
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity","onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","onRestart()")
    }
}