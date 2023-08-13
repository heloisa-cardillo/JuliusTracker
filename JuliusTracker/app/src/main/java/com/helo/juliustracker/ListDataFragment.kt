package com.helo.juliustracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.DOMStringList


class ListDataFragment : Fragment(), Click_lista {

//    private lateinit var binding: ActivityMainBinding
    companion object{
        const val PESO_parameter = "p"
    const val RACA0_parameter = "r"
    const val DATA_parameter = "r"

    }


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


//            val dados: MutableList<TextView> = mutableListOf(
//                view.findViewById(R.id.peso),
//             view.findViewById(R.id.cantar),
//           view.findViewById(R.id.data)

//            val dados: MutableList<Medicine> = mutableListOf(
//                val nomeremedio
//
////
//            view.findViewById(R.id.nome_remedio).Uri.parse(),
//            view.findViewById(R.id.cantar).Uri.parse(),
//            view.findViewById(R.id.data).Uri.parse())

        val comeu_racao_formulario = view.findViewById<TextView>(R.id.comeuracao)
            val peso_formulario = view.findViewById<TextView>(R.id.peso).text
            val data_formulario = view.findViewById<TextView>(R.id.data)

        view.findViewById<FloatingActionButton>(R.id.share_button).setOnClickListener {
//            val peso_uri = Uri.parse(PESO_parameter).buildUpon()
//            val peso_uri = BASE_uri.appendQueryParameter(PESO_parameter,"PESO")




//
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$peso_formulario")
//                    ,"$peso_formulario","$data_formulario")
                type = "text/*"
            }
            val shareIntent = Intent.createChooser(sendIntent, "$peso_formulario")
            startActivity(shareIntent)
        }



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
