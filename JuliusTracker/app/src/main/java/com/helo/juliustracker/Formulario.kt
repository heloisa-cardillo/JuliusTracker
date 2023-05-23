package com.helo.juliustracker

public data class Formulario(
    var data: String,
    var peso: Double,
    var cantou: Boolean,
    var comeuracao: Boolean,
    var remedios: List<Medicine>
)

public data class Medicine(
    var nomeremedio: String,
    var vezesaodia: String,
    var data: String,
    var quantidadepapa: String)

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
val listaFormulario = listOf(
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
