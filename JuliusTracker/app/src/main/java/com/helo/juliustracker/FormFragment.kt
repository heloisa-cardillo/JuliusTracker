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
        rv_remedio.setHasFixedSize(true)


        val adapterDetails = AdapterDetails(listaMedice)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        rv_remedio.adapter= adapterDetails

//        view.findViewById<FloatingActionButton>(R.id.mais).setOnClickListener {
//            findNavController().navigate(R.id.list_to_detail)
//        }

    }
}
