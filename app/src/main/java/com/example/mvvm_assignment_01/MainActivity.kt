package com.example.mvvm_assignment_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_tests.R
import com.example.mvvm_assignment_01.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}