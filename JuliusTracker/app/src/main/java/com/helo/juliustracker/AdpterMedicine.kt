package com.helo.juliustracker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class AdpterMedicine(private val itemsformulario: List<Formulario>, private val clickLista: Click_lista): RecyclerView.Adapter<AdpterMedicine.FormularioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormularioViewHolder {
        //criar as visualizacoes em tela - criar os itens de lista
        val viewFormulario =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_data_item, parent, false)
        return FormularioViewHolder(viewFormulario)
        // no from passa o contexto da classe, parametros - class AdapterMedicice (xxx)
    }

    override fun getItemCount(): Int = itemsformulario.size
    //tamanho da lista

    override fun onBindViewHolder(holder: FormularioViewHolder, position: Int) {
        //exibir as visualizacoes para o usuario
        holder.peso.text = itemsformulario[position].peso.toString()
        holder.data.text= itemsformulario[position].data.toString()


        holder.itemView.setOnClickListener {
            clickLista.onClick(itemsformulario[position])
        }

        if (itemsformulario [position].cantou){
            holder.cantou.text = "Ele cantou"
        } else {
            holder.cantou.text = "Ele não cantou"        }


        holder.botaoLDF.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, itemsformulario [position].buildForShare())
                type = "*/*"
            }
            val shareIntent = Intent.createChooser(sendIntent, "Compartilhar item")
          holder.itemView.context.startActivity(shareIntent)

        }

    }


       class FormularioViewHolder(
           private val cardViewBinding: View
       ): RecyclerView.ViewHolder(cardViewBinding)
       { val peso = itemView.findViewById<TextView>(R.id.peso)
        val cantou = itemView.findViewById<TextView>(R.id.cantar)
        val data = itemView.findViewById<TextView>(R.id.data)
       val botaoLDF = itemView.findViewById<Button>(R.id.share_FLD)}
}

//ViewHolder: representacao no nosso Adapter do nosso layout no xml => holder do layout xml dentro do nosso Adapter