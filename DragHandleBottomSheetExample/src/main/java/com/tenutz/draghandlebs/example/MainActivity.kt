package com.tenutz.draghandlebs.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tenutz.draghandlebs.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}