//Video x

//package com.helo.juliustracker
//
//import android.content.Context
//
//class Prefs (val context: Context) {
//    val SHARED_NAME = "Mydtb"
//    val SHARED_USER_NAME = "username"
//    val SHARED_VIP = "vip"
//
//    val storage = context.getSharedPreferences(SHARED_NAME, 0)
//
//    fun saveName(name: String){
//        storage.edit().putString(SHARED_USER_NAME, name).apply()
//    }
//
//    fun saveVip(vip:Boolean){
//        storage.edit().putBoolean(SHARED_VIP, vip).apply()
//    }
//
//    fun getName() {
//        storage.getString(SHARED_USER_NAME, "")!!
//    }
//
//    fun getVIP(): Boolean {
//        return storage.getBoolean(SHARED_VIP,false)
//    }
//}