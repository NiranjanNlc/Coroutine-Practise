package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

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

        //we can only do network call in the Io thread so
        GlobalScope.launch(Dispatchers.IO) {
            val value = doNetworkCall1()
        //Ui is updated only form the main thread so we are switching the context
            withContext(Dispatchers.Main)
            {
                //update  the Ui from here

            }
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