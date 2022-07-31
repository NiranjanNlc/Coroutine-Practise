package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.*
import org.lniranjan.coroutinepractise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        GlobalScope.launch {
            delay(5000)
            val networkcall1 = doNetworkCall1()
            val networkcall2 = doNetworkCall2()
            // delays are added ip
            Log.d(" inside ","$networkcall1")
            Log.d(" inside ","$networkcall2")
        }
        //we can only do network call in the Io thread so
        GlobalScope.launch(Dispatchers.IO) {
            val value = doNetworkCall1()
            Log.d(" inside Io ","${Thread.currentThread().name}")

            //Ui is updated only form the main thread so we are switching the context
            withContext(Dispatchers.Main)
            {
                //update  the Ui from here
                Log.d(" inside main ","${Thread.currentThread().name}")
                binding.hellotext.text = value
            }
        }

    }
    suspend fun doNetworkCall1(): String {
        delay(3000)
        return " network call 1"
    }
    suspend fun doNetworkCall2(): String {
        return " network call 2" 
        }
}