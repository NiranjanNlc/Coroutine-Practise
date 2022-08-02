package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.lniranjan.coroutinepractise.databinding.ActivityMainBinding
import org.lniranjan.coroutinepractise.databinding.ActivityRunBlockingBinding

class RunBlockingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRunBlockingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_run_blocking)
        Log.d(" interval ", "before  of runblocking ")

        runBlocking {
            delay(1000)
            Log.d(" interval ", "start of runblocking ")
            launch(Dispatchers.Main) {
                Log.d(" interval ", "main  runblocking ")
                binding.textView .text = " run blokcing  "
            }
            launch(Dispatchers.IO) {
                Log.d(" interval ", "Io  runblocking ")
            }
            delay(2000)
        }
        Log.d(" interval ", "after of runblocking ")

    }
}