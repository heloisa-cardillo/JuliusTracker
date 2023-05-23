//package com.helo.juliustracker
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.graphics.Color
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.helo.juliustracker.FormFragment as FormFragment1
//import com.helo.juliustracker.ListDataFragment as HeloJuliustrackerListDataFragment
//
//class SplashScreen : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        supportActionBar?.hide()
//        window.statusBarColor= Color.parseColor("#99E89D")
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, FormFragment1::class.java)
//            startaActivityFragment(intent)
//            finish()
//        },2000)
//
//
//
//
//    }
//
//
//}
