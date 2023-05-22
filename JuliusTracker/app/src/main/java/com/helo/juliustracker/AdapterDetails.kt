package com.helo.juliustracker

import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDetails (private val itemsformulario:List<Formulario>): RecyclerView.Adapter<AdapterDetails.DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        //criar as visualizacoes em tela - criar os itens de lista
        val viewDetails =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_form, parent, false)
        // no from passa o contexto da classe, parametros - class AdapterMedicice (xxx)
        val holder2 = DetailsViewHolder(viewDetails)
        return holder2
    }

    override fun getItemCount(): Int = itemsformulario.size
    //tamanho da lista

    override fun onBindViewHolder(holder2: DetailsViewHolder, position: Int) {
        //exibir as visualizacoes para o usuario
        holder2.nomeremedio.text = itemsformulario[position].nome_remedio.toString()
        holder2.qtdpapa.text= itemsformulario[position].quantidadepapa.toString()
        holder2.remedios.text= itemsformulario[position].remedios.toString()
    }
    class FormularioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val peso = itemView.findViewById<TextView>(R.id.peso)
        val cantou = itemView.findViewById<TextView>(R.id.cantar)
        val data = itemView.findViewById<TextView>(R.id.data)
    }

}