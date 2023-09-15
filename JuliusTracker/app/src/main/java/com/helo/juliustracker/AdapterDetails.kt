package com.helo.juliustracker
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
class AdapterDetails(private val itemsdetails: List<Medicine>) : RecyclerView.Adapter<AdapterDetails.DetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        //criar as visualizacoes em tela - criar os itens de lista
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_form_item, parent, false)
        return DetailsViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemsdetails.size
    //tamanho da lista
    override fun onBindViewHolder(holder2: DetailsViewHolder, position: Int) {
        //exibir as visualizacoes para o usuario


        holder2.nomeremedio.text = itemsdetails[position].nomeremedio.toString()
        holder2.vezesaodia.text = itemsdetails[position].vezesaodia.toString()
        holder2.seta2.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_VIEW
                putExtra(Intent.EXTRA_TEMPLATE, itemsdetails[position].buildForShareRemedios())
            }
            val shareIntent = Intent.createChooser(sendIntent, "Compartilhar item")
            holder2.cardview.context.startActivity(shareIntent)

        }

    }
    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeremedio = itemView.findViewById<TextView>(R.id.nome_remedio)
        val vezesaodia = itemView.findViewById<TextView>(R.id.vezes_dia)
        val cardview = itemView.findViewById<CardView>(R.id.cardview)
        val seta2 = itemView.findViewById<ImageView>(R.id.seta2)
    }
}





