package com.helo.juliustracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_data,container,false)
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

        val adapterMedicine = AdpterMedicine(listaFormulario)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        recycler_view_teste.adapter= adapterMedicine

        view.findViewById<FloatingActionButton>(R.id.mais).setOnClickListener {
            findNavController().navigate(R.id.list_to_detail)
        }
    }
}

//childFragmentManager.beginTransaction().add(
//FormFragment(),
//null
//).commit()
