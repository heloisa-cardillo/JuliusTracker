package com.helo.juliustracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdpterMedicine (private val context: Context, private val formulario: MutableList<Formulario>): RecyclerView.Adapter<AdpterMedicine.MedicineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        //responsavel por criar as visualizacoes em tela; onde cria as views
        val itemLista = LayoutInflater.from(context).inflate(R.layout.fragment_list_data,parent,false)
        val holder = MedicineViewHolder(itemLista)
        return holder
    }


    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        //metodo responsavel por exibir as visualizacoes para oa usuario; onde exibe as views
        (holder.itemView as TextView).text
    }


    override fun getItemCount(): Int = formulario.size
        //tamanho da lista


   private inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recycler = itemView.findViewById<TextView>(R.id.recycler_view_teste)

    }
}