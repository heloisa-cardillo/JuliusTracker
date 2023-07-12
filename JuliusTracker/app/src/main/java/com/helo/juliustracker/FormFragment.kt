package com.helo.juliustracker

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.helo.juliustracker.databinding.FragmentFormBinding

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
       val peso2 =  view.findViewById<TextInputLayout>(R.id.peso2)
        peso2.editText?.text.toString()


        val adapterDetails = AdapterDetails(listaMedice)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        rv_remedio.adapter= adapterDetails


        val qtapapa = view.findViewById<TextInputLayout>(R.id.qtdpapa)
        val teste = view.findViewById<Button>(R.id.teste)
        val sharedPref = Prefs(requireContext())
        sharedPref.name= "Heloisa"



        val save_button = view.findViewById<Button>(R.id.save_button)
           save_button.setOnClickListener{
               Toast.makeText(requireContext(),"Clicou no salvar",Toast.LENGTH_LONG).show()

        }


//        view.findViewById<FloatingActionButton>(R.id.mais).setOnClickListener {
//            findNavController().navigate(R.id.list_to_detail)
//        }

//        val button: Button = findViewById(R.id.button_send)
//        button.setOnClickListener {
//            // Do something in response to button click
//        }

    }
}
