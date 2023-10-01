package com.helo.juliustracker
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.helo.juliustracker.databinding.FragmentFormBinding

public class AdapterDetails(private val itemsdetails: List<Medicine>, val onClickMedicineListener: OnClickMedicineListener) : RecyclerView.Adapter<AdapterDetails.DetailsViewHolder>() {
    private lateinit var bingind : FragmentFormBinding

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


        holder2.itemView.setOnClickListener{
          val onClickMedicineListener= onClickMedicineListener.onClick(medicine = itemsdetails[position])

        }





    }

    private fun requireContext(itemsdetails: List<Medicine>): Context {
        TODO("Not yet implemented")
    }



  public  class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeremedio = itemView.findViewById<TextView>(R.id.nome_remedio)
        val vezesaodia = itemView.findViewById<TextView>(R.id.vezes_dia)
        val save_button2 = itemView.findViewById<FloatingActionButton>(R.id.save_button2)
        val remedio_detail = itemView.findViewById<TextInputLayout>(R.id.remedio_detail)
    }
}





