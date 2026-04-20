package com.example.personalfinancemanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.personalfinancemanager.ui.InputFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ga_fragment_container, InputFragment())
                .commit()
        }
    }
}