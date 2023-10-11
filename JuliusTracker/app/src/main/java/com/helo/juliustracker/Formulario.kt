package com.helo.juliustracker

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.Toast


//fun addMedicine(nomeremedio: String,vezesaodia: String,quantidaderemedio: String){
//  if (nomeremedio )
//}

public data class Formulario(
    var data: String,
    var peso: Double,
    var cantou: Boolean,
    var comeuracao: Boolean,
    var remedios: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        (parcel.createTypedArrayList(Medicine) ?: emptyList()) as String
    ){
    }

    fun buildForShare(): String {
        return "data ${data} \npeso: ${peso} \ncantou: ${cantou} \ncomeu: ${comeuracao} \nremedio: ${remedios.toString()}"
    }

    override fun toString(): String {
        return buildForShare()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
        parcel.writeDouble(peso)
        parcel.writeByte(if (cantou) 1 else 0)
        parcel.writeByte(if (comeuracao) 1 else 0)
        parcel.writeTypedList(remedios)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Formulario> {
        override fun createFromParcel(parcel: Parcel): Formulario {
            return Formulario(parcel)
        }

        override fun newArray(size: Int): Array<Formulario?> {
            return arrayOfNulls(size)
        }
    }

}

private fun Parcel.writeTypedList(remedios: String) {

}

public data class Medicine(
    var id: String,
    var nomeremedio: String,
    var vezesaodia: String,
//    var data: String,
    var quantidaderemedio: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
//        parcel.readString().orEmpty(),
        parcel.readString().orEmpty()
    )
    fun buildForShareRemedios():String{
        return "\n *${nomeremedio} \nvezes ao dia: ${vezesaodia} \n ml: ${quantidaderemedio}"
    }

    override fun toString(): String {
        return buildForShareRemedios()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomeremedio)
        parcel.writeString(vezesaodia)
//        parcel.writeString(data)
        parcel.writeString(quantidaderemedio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Medicine> {
        override fun createFromParcel(parcel: Parcel): Medicine {
            return Medicine(parcel)
        }

        override fun newArray(size: Int): Array<Medicine?> {
            return arrayOfNulls(size)
        }
    }
}

public val listaMedice = mutableListOf(
    Medicine(
        id = "a6de983b-8814-45aa-a707-bda204da4a5e",
        nomeremedio = "Gardenal",
        vezesaodia = "3 vezes",
        quantidaderemedio = "1ml"
    ),
    Medicine(
        id = "62972f6e-40dc-47a3-9044-9261c2f6d61a",
        nomeremedio = "Rivotril",
        vezesaodia = "2 vezes",
        quantidaderemedio = "1ml"
    ),
    Medicine(
        id = "d0bc29de-a9cd-4f85-ab04-6011640f6886",
        nomeremedio = "Leviracetam",
        vezesaodia = "3 vezes",
        quantidaderemedio= "1ml"
    ),
    Medicine(
        id ="ab193274-2d3a-412c-91f7-73a01a8ec3ad",
        nomeremedio = "Valproato",
        vezesaodia = "3 vezes",
        quantidaderemedio = "1ml"
    ),

)

public fun addMedicine (id: String, nomeremedio: String,vezesaodia: String,quantidaderemedio: String) {
    listaMedice.add(
        Medicine(
            id = id,
            nomeremedio = nomeremedio,
            vezesaodia = vezesaodia,
            quantidaderemedio = quantidaderemedio
        )
    )
}

public val listaFormulario = mutableListOf(
    Formulario (
        data = "22/03",
        peso = 40.0,
        cantou = false,
        comeuracao = true,
        remedios = listaMedice.map { it.buildForShareRemedios() }.joinToString(separator = "")
    ) ,
    Formulario(
        data = "23/03",
        peso = 42.0,
        cantou = true,
        comeuracao = true,
        remedios = listaMedice.map { it.buildForShareRemedios() }.joinToString(separator = "")
    ),
    Formulario(
        data = "24/03",
        peso = 44.0,
        cantou = true,
        comeuracao = true,
        remedios = listaMedice.map { it.buildForShareRemedios() }.joinToString(separator = "")
    )
)

