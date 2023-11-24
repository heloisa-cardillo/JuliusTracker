package com.helo.juliustracker

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout

class FormFragment : Fragment(), OnClickMedicineListener {

    private lateinit var binding: OnClickMedicineListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
        // nada funciona abaixo do returno

    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formulario: Formulario? = arguments?.getParcelable("data")


        val rv_remedio = view.findViewById<RecyclerView>(R.id.rv_remedio)
        rv_remedio.layoutManager = LinearLayoutManager(requireContext())
        rv_remedio.setHasFixedSize(true)
        val peso2 = view.findViewById<TextInputLayout>(R.id.peso2)
        peso2.editText?.setText(formulario?.peso.toString())
        val adapterDetails = AdapterDetails(listaMedice, this)
        //nao passa contexto para o adapter -> ja tem acesso e pode levar a problemas de memoria (memoryleak)
        rv_remedio.adapter = adapterDetails
        rv_remedio.isNestedScrollingEnabled = false
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
            findNavController().navigateUp()
            //finished()
        }

        view.findViewById<ImageView>(R.id.lupa).setOnClickListener {
            findNavController().navigate(R.id.detail_to_medicine)
        }

        view.findViewById<ImageView>(R.id.trash).setOnClickListener{
            showAlertDialog()
        }

        setFragmentResultListener("mudou"){requestKey, bundle ->
        adapterDetails.notifyDataSetChanged()

        }


    }



    override fun onClick(medicine: Medicine?) {
        findNavController().navigate(R.id.medicine, args = bundleOf("medicine" to medicine))
    }

    private fun showAlertDialog(){
        AlertDialog.Builder(context)
            .setMessage("Tem certeza?")
            .setPositiveButton("Sim", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(context, " Deletado", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Nao", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(context, " Nao deletado", Toast.LENGTH_SHORT).show()
            })
            .setTitle("Deletar")
            .create()
            .show()
    }

}



        //findNavController().popBackStack() - FILO




