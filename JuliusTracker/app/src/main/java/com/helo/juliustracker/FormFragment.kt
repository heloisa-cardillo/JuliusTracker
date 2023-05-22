package com.helo.juliustracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv_remedio = view.findViewById<RecyclerView>(R.id.rv_remedio)
        rv_remedio.layoutManager = LinearLayoutManager(requireContext())
        // layout manager define o formato da nossa lista, como os itens vao ser visualizados
        // se quiser deixar na horizontal colocar ,LinearLayoutManager.HORIZONTAL depois de this
        rv_remedio.setHasFixedSize(true)
        //otimizar/otimizar nossa lista
        //Configurar o Adapater

        val adapterDetails = AdapterDetails(listaFormulario)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        rv_remedio.adapter= adapterDetails

        view.findViewById<FloatingActionButton>(R.id.mais).setOnClickListener {
            findNavController().navigate(R.id.list_to_detail)
        }

    }
}
