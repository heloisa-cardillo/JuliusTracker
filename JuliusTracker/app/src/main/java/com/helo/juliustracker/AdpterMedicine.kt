package com.helo.juliustracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdpterMedicine (private val context: Context, private val itemsformulario: MutableList<Formulario>): RecyclerView.Adapter<AdpterMedicine.FormularioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormularioViewHolder {
        //criar as visualizacoes em tela - criar os itens de lista
        val viewFormulario =
            LayoutInflater.from(context).inflate(R.layout.fragment_data_formulario, parent, false)
        // no from passa o contexto da classe, parametros - class AdapterMedicice (xxx)
        val holder = FormularioViewHolder(viewFormulario)
        return holder
    }

    override fun getItemCount(): Int = itemsformulario.size
    //tamanho da lista

    override fun onBindViewHolder(holder: FormularioViewHolder, position: Int) {
        //exibir as visualizacoes para o usuario
        holder.peso.text = itemsformulario[position].peso.toString()
        holder.cantou.text = itemsformulario[position].cantou.toString()
        holder.comeu.text = itemsformulario[position].comeuracao.toString()
        holder.qtdpapa.text = itemsformulario[position].quantidadepapa.toString()
        holder.remedios.text = itemsformulario[position].remedios.toString()
    }

    inner class FormularioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val peso = itemView.findViewById<TextView>(R.id.peso)
        val cantou = itemView.findViewById<Switch>(R.id.switch1)
        val comeu = itemView.findViewById<Switch>(R.id.switch2)
        val qtdpapa = itemView.findViewById<TextView>(R.id.qtdpapa)
        val remedios = itemView.findViewById<TextView>(R.id.remedios)

    }
}


//ViewHolder: representacao no nosso Adapter do nosso layout no xml => holder do layout xml dentro do nosso Adapter