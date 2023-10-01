package com.helo.juliustracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.helo.juliustracker.databinding.FragmentFormBinding

class MedicineFragment : BottomSheetDialogFragment() {

    private lateinit var bingind: FragmentFormBinding
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
        remediodetail.editText?.setText(medicine?.nomeremedio.toString())
        val vezesdiadetail = view.findViewById<TextInputLayout>(R.id.vezes_ao_dia_detail)
        vezesdiadetail.editText?.setText(medicine?.vezesaodia.toString())
        val qtddetail = view.findViewById<TextInputLayout>(R.id.qtd_detail)
        qtddetail.editText?.setText(medicine?.quantidaderemedio.toString())

        val button_save2 = view.findViewById<Button>(R.id.save_button2)
        button_save2.setOnClickListener {
            addMedicine(id = "id",remediodetail.editText?.text.toString()?:"", vezesdiadetail.editText?.text.toString()?:"",qtddetail.editText?.text.toString()?:"")
            setFragmentResult("mudou", bundleOf("adicionou" to true))
            dismiss()
        }


    }

}

private fun namesEdit() {

}









