package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class JobActivity : AppCompatActivity() {
    val TAG = "JObActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)
        //Ilustratio of job
        illustrateJob()
        //Illustrate of is active
        isActiveJob()
        withTimeOutJob()
    }

    private fun withTimeOutJob() {
        val job = GlobalScope.launch {
           withTimeout(4000)
           {
               for (i in 20..60) {
                   delay(1000)
                   Log.d(" factiorail of $i", getFactorial(i).toString())
               }
           }
        }
        runBlocking {
            delay(5000)
            if (job.isCancelled)
            Log.d(TAG," time out of job")
        }
    }

    private fun isActiveJob() {
        val job = GlobalScope.launch {
           for ( i in 20 .. 60 )
           {
               delay(1000)
               if (isActive)
               Log.d(" factiorail of $i", getFactorial(i).toString())
           }
        }
        runBlocking {
            Log.d(TAG, " run blockin of the job ")
            delay(6000)
            job.cancel()
            Log.d(TAG, " run blockin of the job  canceled ")
        }
        Log.d(TAG, " End of everything ")
    }

    fun getFactorial(num: Int): Long {
        if (num >= 1)
            return num * getFactorial(num - 1)
        else
            return 1
    }

    private fun illustrateJob() {
        val job = GlobalScope.launch {
            Log.d(TAG, " Starting of the job ")
            delay(5000)
            Log.d(TAG, "Ending  of the job ")
        }
        runBlocking {
            Log.d(TAG, " run blockin of the job ")
            delay(3000)
            job.cancel()
            Log.d(TAG, " run blockin of the job  canceled ")
        }
        Log.d(TAG, " End of everything ")
    }
}