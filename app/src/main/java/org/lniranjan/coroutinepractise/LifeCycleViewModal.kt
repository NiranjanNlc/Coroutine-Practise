package org.lniranjan.coroutinepractise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifeCycleViewModal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_view_modal)
        lifecycleScope.launch {
            while (true)
            {
                delay(1000)
                Log.d("my activity "," running " )
            }
        }
        GlobalScope.launch {
            delay(5000)
            startActivity(Intent(this@LifeCycleViewModal,JobActivity::class.java))
            finish()
        }
    }
}