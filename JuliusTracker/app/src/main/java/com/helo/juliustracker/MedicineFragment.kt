package com.helo.juliustracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputLayout

class MedicineFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val medicine: Medicine? = arguments?.getParcelable("medicine")


        val remediodetail = view.findViewById<TextInputLayout>(R.id.remedio_detail)
        remediodetail.editText?.setText(medicine?.quantidaderemedio.toString())
       val vezesdiadetail = view.findViewById<TextInputLayout>(R.id.vezes_ao_dia_detail)
        vezesdiadetail.editText?.setText(medicine?.quantidaderemedio.toString())
        val qtddetail = view.findViewById<TextInputLayout>(R.id.qtd_detail)
        qtddetail.editText?.setText(medicine?.quantidaderemedio.toString())



        }
    }





