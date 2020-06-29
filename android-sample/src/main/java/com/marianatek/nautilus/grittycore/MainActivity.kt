package com.marianatek.nautilus.grittycore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marianatek.marianakit.platformName
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Kotlin Rock on ${platformName()}"
    }
}
