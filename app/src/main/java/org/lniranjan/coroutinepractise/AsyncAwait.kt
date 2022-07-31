package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class AsyncAwait : AppCompatActivity() {
    val TAG = "AsyncAwait"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await)

        GlobalScope.launch {
            var time =    measureTimeMillis {
                var job1 = doNetworkCall1()
                var job2 = doNetworkCall2()
                Log.d(TAG, job1)
                Log.d(TAG, job2)
            }
            Log.d(" withiut async ", time.toString())
        }
        GlobalScope.launch {
            var time2=    measureTimeMillis {
                var job3=  async {doNetworkCall1() }
                var job4 = async { doNetworkCall2()}
          job3?.let { Log.d(TAG, it.await()) }
          job4?.let { Log.d(TAG, it.await()) }
      }
            Log.d("with async ", time2.toString())
        }
    }
    suspend fun doNetworkCall1(): String {
        delay(3000)
        return " network call 1"
    }
    suspend fun doNetworkCall2(): String {
        delay(3000)
        return " network call 2"
    }
}