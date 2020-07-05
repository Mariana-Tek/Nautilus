package com.marianatek.nautilus.grittycore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.marianatek.marianakit.Mariana
import com.marianatek.marianakit.apiclient.ResultType
import com.marianatek.marianakit.platformName
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val mariana = Mariana()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        textView.text = "Kotlin Rock on ${platformName()}"

        lifecycleScope.launchWhenResumed {
            val locationsCall = mariana.getLocations()

            try {
                locationsCall.get {
                    lifecycleScope.launch(Dispatchers.Main) {
                        textView.text = when (it) {
                            is ResultType.Success -> it.data.first().name ?: "First Location"
                            is ResultType.Failure -> it.throwable.localizedMessage ?: "Mariana Failure"
                        }
                    }
                }
            } catch (e: Exception) {
                locationsCall.cancel()
            }
        }
    }
}
