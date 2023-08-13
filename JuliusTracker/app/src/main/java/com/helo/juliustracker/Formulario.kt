package com.helo.juliustracker

import android.os.Parcel
import android.os.Parcelable


public data class Formulario(
    var data: String,
    var peso: Double,
    var cantou: Boolean,
    var comeuracao: Boolean,
    var remedios: List<Medicine>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.createTypedArrayList(Medicine) ?: emptyList()
    ){
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

public data class Medicine(
    var nomeremedio: String,
    var vezesaodia: String,
    var data: String,
    var quantidadepapa: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty()
    )


    {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomeremedio)
        parcel.writeString(vezesaodia)
        parcel.writeString(data)
        parcel.writeString(quantidadepapa)
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

val listaMedice = listOf(
    Medicine(
        nomeremedio = "Gardenal",
        vezesaodia = "3 vezes",
        data = "22/03",
        quantidadepapa = "1ml"
    ),
    Medicine(
        nomeremedio = "Rivotril",
        vezesaodia = "2 vezes",
        data = "22/03",
        quantidadepapa = "1ml"
    ),
    Medicine(
        nomeremedio = "Leviracetam",
        vezesaodia = "3 vezes",
        data = "22/03",
        quantidadepapa = "1ml"
    ),
    Medicine(
        nomeremedio = "Valproato",
        vezesaodia = "3 vezes",
        data = "22/03",
        quantidadepapa = "1ml"
    )

)
val listaFormulario = mutableListOf(
    Formulario (
        data = "22/03",
        peso = 40.0,
        cantou = false,
        comeuracao = true,
        remedios = emptyList()
    ) ,
    Formulario(
        data = "23/03",
        peso = 42.0,
        cantou = true,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario(
        data = "24/03",
        peso = 44.0,
        cantou = true,
        comeuracao = true,
        remedios = emptyList()
    )
)
