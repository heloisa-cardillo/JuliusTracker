package com.helo.juliustracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashScreenActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        var splashscreen = installSplashScreen()
        super.onCreate(savedInstanceState, persistentState)
        splashscreen.setKeepOnScreenCondition{true}

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}