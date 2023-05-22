package com.helo.juliustracker

public data class Formulario(
    var data: String,
    var peso: Double,
    var cantou: Boolean,
    var quantidadepapa: Int,
    var comeuracao: Boolean,
    var remedios: List<Medicine>
)

public data class Medicine(
    var nomeremedio: String,
    var vezesaodia: Int,
    var quantidade: Double
)

val listaFormulario = listOf(
    Formulario (
        data = "22/03",
        peso = 40.0,
        cantou = false,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ) ,
    Formulario(
        data = "23/03",
        peso = 42.0,
        cantou = true,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario(
        data = "24/03",
        peso = 44.0,
        cantou = true,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    )
)
