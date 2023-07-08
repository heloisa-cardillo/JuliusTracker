package com.helo.juliustracker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.helo.juliustracker.databinding.ActivityMainBinding
import com.helo.juliustracker.databinding.FragmentFormBinding

class SaveButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_form)
        val peso2 = findViewById<EditText>(R.id.peso2)
        val qtapapa = findViewById<EditText>(R.id.qtdpapa)
        val save = findViewById<Button>(R.id.save_button)
        val teste = findViewById<Button>(R.id.teste)
        val sharedPref = getSharedPreferences("addName",Context.MODE_PRIVATE)
        var edit = sharedPref.edit()


        save.setOnClickListener {
            edit.putString("peso",peso2.text.toString())
            edit.putString("qta papa",qtapapa.text.toString())
            edit.commit()
            Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show()
        }
        teste.setOnClickListener {
            val name = sharedPref.getString("peso","default value")
            val add = sharedPref.getString("qta papa", "default value")
            Toast.makeText(this, "peso", Toast.LENGTH_SHORT).show()
        }
    }
}


// Video s
//    lateinit var saved_text: TextView
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_form)
//
//        val editText: EditText = findViewById(R.id.peso2)
//        saved_text = findViewById(R.id.teste)
//        val btn: Button = findViewById(R.id.save_button)
//
//        ShowInfo()
//
//        btn.setOnClickListener {
//            val saved_text:String = editText.text.toString()
//            saveInfData(saved_text)
//        }
//
//
//    }
//
//    private fun saveInfData(saved_text: String) {
//        ShowInfo()
//        val sharedPreferences: SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
//        val save_text: SharedPreferences.Editor = sharedPreferences.edit()
//        save_text.putString("name", saved_text).commit()
//    }
//
//    private fun ShowInfo() {
//
//        val sharedPreferences: SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
//        val text1: String? = sharedPreferences.getString("name", "")
//        saved_text.setText(text1)
//    }
//}


//Video t
//        teste()
//
//    }
//
//    fun teste(){
//        findViewById<Button>(R.id.save_button).setOnClickListener{
//
//        }
//
//        fun salvarpeso(){
//            if (findViewById<EditText>(R.id.peso2).text.toString().isNotEmpty()){
//                prefs.saveName
//                //Guardar Informacao
//            } else {}
//        }
//
//    }


// Video u
//
//    private var binding: ActivityMainBinding? = null
//    private val binding get() = binding!!
//
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        setContentView(R.layout.fragment_form)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }
//}

// Video v
//    lateinit var pref: SharedPreferences
//    lateinit var editor: SharedPreferences
//    lateinit var con: Context
//    var PRIVATEMODE: Int=0
//
//    constructor(con: Context) {
//        this.con = con
//        pref = con.getSharedPreferences(PREF_NAME,PRIVATEMODE)
//        editor = pref.edit()
//    }
//
//    companion object {
//        val PREF_NAME = "Login_Preference"
//        val IS_LOGIN = "isLogin"
//        val KEY_NAME = "username"
//        val KEY_MAIL = "email"
//    }
//
//    fun createLogin(username: String, email:String) {
//        editor.putBoolean


//Video z
//    private lateinit var binding: FragmentFormBinding
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {

//        super.onCreate(savedInstanceState, persistentState)
//        binding = FragmentFormBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.saveButton.setOnClickListener {
//            val peso2 = binding.peso2.text.toString()
//            binding.saveButton.setText(peso2)
//        }


//Video y
//val peso2 = view?.findViewById<EditText>(R.id.peso2)
//val qtapapa = view?.findViewById<EditText>(R.id.qtdpapa)
//val save = view?.findViewById<Button>(R.id.save_button)
//val sharedPref = getSharedPreferences ()
//
//save.setOnClickListener {  }
//
//val sharedPref = activity?.getSharedPreferences(
//    getString(R.string.for), Context.MODE_PRIVATE)

//    companion object {
//        const val PESO_KEY = "PESO_KEY"
//        const val QTDPAPINHA_KEY = "QTAPAPINHA_KEY"
//        const val REMEDIO_KEY = "REMEDIO_KEY"
//        const val SHARED_PRES = "com.softsuit.codelab.datamanagement.sharedprefs"
//    }

