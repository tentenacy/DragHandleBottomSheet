package com.tenutz.draghandlebs.example

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class GlobalApplication: Application() {

    override fun onCreate() {

        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}