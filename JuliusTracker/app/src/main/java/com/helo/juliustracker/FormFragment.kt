package com.helo.juliustracker

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.graphics.drawable.Icon
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.helo.juliustracker.databinding.FragmentFormBinding

class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding
//
//    private lateinit var binding: FragmentFormBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmentFormBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initRecyclerView1()
//    }
//
//    private fun initRecyclerView1(){
//        binding.rvRemedio.layoutManager = LinearLayoutManager(this)
//        binding.rvRemedio.setHasFixedSize(true)
//        binding.rvRemedio.adapter = AdapterDetails(getList())
//    }
//
//    private fun getList() = listOf(
//        "Gardenal",
//        "Rivotril",
//        "Brometo"
//    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)

        binding.trash.setOnClickListener {
            Toast.makeText(requireContext(), "Clicou no buscar", Toast.LENGTH_LONG).show()
        }

        binding.lupa.setOnClickListener {
            Toast.makeText(requireContext(), "Clicou no salvar", Toast.LENGTH_LONG).show()
        }

        binding = FragmentFormBinding.inflate(layoutInflater)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formulario: Formulario? = arguments?.getParcelable("data")


        val rv_remedio = view.findViewById<RecyclerView>(R.id.rv_remedio)
        rv_remedio.layoutManager = LinearLayoutManager(requireContext())
        rv_remedio.setHasFixedSize(true)
        val peso2 = view.findViewById<TextInputLayout>(R.id.peso2)
        peso2.editText?.setText(formulario?.peso.toString() ?: "meu ovo")
        val adapterDetails = AdapterDetails(listaMedice)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        rv_remedio.adapter = adapterDetails


//        val qtapapa = view.findViewById<TextInputLayout>(R.id.qtdpapa)
//        val sharedPref = Prefs(requireContext())
//        sharedPref.name= "Heloisa"

        val lupa_icon = view.findViewById<ImageView>(R.id.lupa)
        lupa_icon.setOnClickListener {
            findNavController().navigate(R.id.detail_to_medicine)
        }

        val lixo_icon = view.findViewById<ImageView>(R.id.trash)
        lixo_icon.setOnClickListener {
            Toast.makeText(requireContext(), "Clicou no deletar", Toast.LENGTH_SHORT).show()
        }

        val return_icon = view.findViewById<ImageView>(R.id.return_icon)
        return_icon.setOnClickListener {
            findNavController().navigate(R.id.detail_to_list)
        }


        view.findViewById<ExtendedFloatingActionButton>(R.id.save_button).setOnClickListener {
            findNavController().navigate(R.id.detail_to_medicine)


        }
    }
}




//            val formulario = Formulario(
//                data = "",
//                peso = 0.0,
//                cantou = false,
//                comeuracao = false,
//                remedios = emptyList()
//            )

        //findNavController().popBackStack() - FILO


//        view.findViewById<FloatingActionButton>(R.id.save_button).setOnClickListener {
//            findNavController().navigate(R.id.list_to_detail)
//        }

//        val button: Button = findViewById(R.id.button_send)
//        button.setOnClickListener {
//            // Do something in response to button click
//        }



