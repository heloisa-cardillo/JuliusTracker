package com.helo.juliustracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDetails(private val itemsdetails: List<Medicine>) : RecyclerView.Adapter<AdapterDetails.DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        //criar as visualizacoes em tela - criar os itens de lista
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_form_item, parent, false)
        return DetailsViewHolder(itemView)
//        val holder2 = DetailsViewHolder(viewDetails)
//        return holder2
    }

    override fun getItemCount(): Int = itemsdetails.size
    //tamanho da lista

    override fun onBindViewHolder(holder2: DetailsViewHolder, position: Int) {
        //exibir as visualizacoes para o usuario

//        val remedio = itemsdetails[position]
//        holder2.nomeremedio.text = remedio.toString()
//
//        val vezes = itemsdetails[position]
//        holder2.vezesaodia.text = vezes.toString()


        holder2.nomeremedio.text = itemsdetails[position].nomeremedio.toString()
        holder2.vezesaodia.text = itemsdetails[position].vezesaodia.toString()
    }

    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeremedio = itemView.findViewById<TextView>(R.id.nome_remedio)
        val vezesaodia = itemView.findViewById<TextView>(R.id.vezes_dia)
    }

}