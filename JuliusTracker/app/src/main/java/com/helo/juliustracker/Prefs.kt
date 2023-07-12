package com.helo.juliustracker

import android.content.Context

class Prefs (val context: Context) {
    val SHARED_NAME = "Mydtb"
    val SHARED_USER_NAME = "username"
    val SHARED_VIP = "vip"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)
    var name:String?
        get() = storage.getString("name", null)
        set(value){storage.edit().putString("name",value).apply()}
}