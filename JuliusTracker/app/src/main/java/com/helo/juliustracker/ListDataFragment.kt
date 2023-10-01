package com.helo.juliustracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.DOMStringList


class ListDataFragment : Fragment(), OnClickFormularioListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_data, container, false)
//        binding = ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler_view_teste = view.findViewById<RecyclerView>(R.id.recycler_view_teste)
        recycler_view_teste.layoutManager = LinearLayoutManager(requireContext())
        // layout manager define o formato da nossa lista, como os itens vao ser visualizados
        // se quiser deixar na horizontal colocar ,LinearLayoutManager.HORIZONTAL depois de this
        recycler_view_teste.setHasFixedSize(true)
        //otimizar/otimizar nossa lista
        //Configurar o Adapater

        val clickLista: OnClickFormularioListener = this
        val adapterMedicine = AdpterMedicine(listaFormulario, this)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        recycler_view_teste.adapter = adapterMedicine



        view.findViewById<FloatingActionButton>(R.id.plus_button).setOnClickListener {
            findNavController().navigate(R.id.list_to_detail)
        }

        val comeu_racao_formulario = view.findViewById<TextView>(R.id.comeuracao)
            val peso_formulario = view.findViewById<TextView>(R.id.peso)
            val data_formulario = view.findViewById<TextView>(R.id.data)

        view.findViewById<FloatingActionButton>(R.id.share_button).setOnClickListener {

            val formulario = listaFormulario

            val formatacao1 = listaFormulario.toString()
            val formatacao2 = listaFormulario.map { it.buildForShare() }.joinToString(separator = "\n\n")
//            val formatacao3 = listaMedice.map { it.buildForShareRemedios() }.joinToString(separator = "\n\n")
//            val formatacao4= formatacao2 + formatacao3
//map = converter/mapear

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, formatacao2)
                type = "*/*"
            }
            val shareIntent = Intent.createChooser(sendIntent, "$peso_formulario")
            startActivity(shareIntent)
        }



    }

    override fun onClick(formulario: Formulario) {
        findNavController().navigate(R.id.list_to_detail, bundleOf("data" to formulario))
    }

}
