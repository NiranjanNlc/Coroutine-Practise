package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            delay(5000)
            Log.d(" inside ","${Thread.currentThread().name}")
            val networkcall1 = doNetworkCall1()
            val networkcall2 = doNetworkCall2()
            // delays are added ip
            Log.d(" inside ","$networkcall1")
            Log.d(" inside ","$networkcall2")
        }
    }
    suspend fun doNetworkCall1(): String {
        delay(3000)
        return " network call 1"
    }
    suspend fun doNetworkCall2(): String {
        delay(3000)
        return " network call 1"
    }
}