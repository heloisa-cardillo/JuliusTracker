package com.helo.juliustracker
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.helo.juliustracker.databinding.FragmentFormBinding
import java.util.UUID

@Suppress("ControlFlowWithEmptyBody")
class MedicineFragment : BottomSheetDialogFragment() {

    private lateinit var bingind: FragmentFormBinding
    var remediodetail : TextInputLayout? = null
    var vezesdiadetail : TextInputLayout? = null
    var qtddetail : TextInputLayout? = null
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
        remediodetail = view.findViewById<TextInputLayout>(R.id.remedio_detail)

       vezesdiadetail = view.findViewById<TextInputLayout>(R.id.vezes_ao_dia_detail)

        qtddetail = view.findViewById<TextInputLayout>(R.id.qtd_detail)
        doneTeclado(vezesdiadetail)

        medicine?.let {
            remediodetail?.editText?.setText(it.nomeremedio)
            vezesdiadetail?.editText?.setText(it.vezesaodia)
            qtddetail?.editText?.setText(it.quantidaderemedio)
        }
        val button_save2 = view.findViewById<Button>(R.id.save_button2)
        button_save2.setOnClickListener {
               salvar()
        }
    }

    fun salvar() {
        if (remediodetail?.editText?.text?.isNotBlank() == true && vezesdiadetail?.editText?.text?.isNotBlank() == true && qtddetail?.editText?.text?.isNotBlank() == true) {
            val myUuid = UUID.randomUUID()
            addMedicine(
                id = myUuid.toString(),
                remediodetail?.editText?.text.toString() ?: "",
                vezesdiadetail?.editText?.text.toString() ?: "",
                qtddetail?.editText?.text.toString() ?: ""
            )
            setFragmentResult("mudou", bundleOf("adicionou" to true))
            dismiss()
        } else {
            Toast.makeText(requireContext(),"Preencha os campos",Toast.LENGTH_LONG).show()
        }
    }

    private fun doneTeclado(done: TextInputLayout?) {
        done?.editText?.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener if (done.editText?.text?.isNotBlank() == true &&
                event?.action == KeyEvent.ACTION_UP && actionId == EditorInfo.IME_ACTION_DONE){
                salvar()
                true
            } else {
                false
            }

        }
    }

}
private fun namesEdit() {
}
//if (itemsformulario [position].cantou){
//    holder.cantou.text = "Ele cantou"
//} else {
//    holder.cantou.text = "Ele não cantou"





