package com.helo.juliustracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recycler_view_teste = findViewById<RecyclerView>(R.id.recycler_view_teste)
        recycler_view_teste.layoutManager = LinearLayoutManager(this)
        // layout manager define o formato da nossa lista, como os itens vao ser visualizados
        // se quiser deixar na horizontal colocar ,LinearLayoutManager.HORIZONTAL depois de this
        recycler_view_teste.setHasFixedSize(true)
        //otimizar/otimizar nossa lista
        //Configurar o Adapater
        val listaFormulario: MutableList<Formulario> = mutableListOf()
        val adapterMedicine = AdpterMedicine(this,listaFormulario)
        recycler_view_teste.adapter= adapterMedicine

        val formulario1 = Formulario(
            peso = 40.0,
            cantou = false,
            quantidadepapa = 150,
            comeuracao = true,
            remedios = emptyList()
        )
        val formulario2 = Formulario(
            peso = 42.0,
            cantou = true,
            quantidadepapa = 120,
            comeuracao = true,
            remedios = emptyList()
        )
        val formulario3 = Formulario(
            peso = 43.0,
            cantou = true,
            quantidadepapa = 100,
            comeuracao = true,
            remedios = emptyList()
        )

    }
}
