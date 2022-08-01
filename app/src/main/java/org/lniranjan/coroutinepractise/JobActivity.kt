package org.lniranjan.coroutinepractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class JobActivity : AppCompatActivity() {
    val TAG = "JObActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)
        //Ilustratio of job
        illustrateJob()
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