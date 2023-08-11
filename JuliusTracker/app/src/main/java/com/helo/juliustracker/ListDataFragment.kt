package com.helo.juliustracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListDataFragment : Fragment(), Click_lista {

//    private lateinit var binding: ActivityMainBinding

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

        val clickLista: Click_lista = this
        val adapterMedicine = AdpterMedicine(listaFormulario, this)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        recycler_view_teste.adapter = adapterMedicine

        view.findViewById<FloatingActionButton>(R.id.plus_button).setOnClickListener {
            findNavController().navigate(R.id.list_to_detail)
        }

//        view.findViewById<FloatingActionButton>(R.id.share_button).setOnClickListener {
//            findNavController().
//        }

//        view.findViewById<FloatingActionButton>(R.id.share_button).setOnClickListener {
//            val s = view.findViewById<RecyclerView>(R.id.testetexto)
//            val shareIntent = Intent()
//            shareIntent.action = Intent.ACTION_SEND
//            shareIntent.type = "text/plain"
//            shareIntent.putExtra(Intent.EXTRA_TEXT, "$s")
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
//            startActivity(Intent.createChooser(shareIntent,"Share"))
//
//        }

        val sendIntent: Intent = Intent().apply {
            val s = view.findViewById<RecyclerView>(R.id.recycler_view_teste)
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$s")
            type = "text/*"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)



    }


    override fun onClick(formulario: Formulario) {
        findNavController().navigate(R.id.list_to_detail, bundleOf("data" to formulario))
    }


//     fun compartilhar(formulario: Formulario) {
//        val intent = Intent(requireContext(), ListDataFragment::class.java)
//        startActivity(intent)
//    }
//

}

//childFragmentManager.beginTransaction().add(
//FormFragment(),
//null
//).commit()
