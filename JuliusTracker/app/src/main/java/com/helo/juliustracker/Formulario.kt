package com.helo.juliustracker

public data class Formulario (
   var peso: Double,
   var cantou: Boolean,
   var quantidadepapa: Int,
   var comeuracao: Boolean,
   var remedios: List<Medicine>
)

public data class Medicine (
    var nomeremedio: String,
    var vezesaodia: Int,
    var quantidade: Double)

val listaFormulario = listOf (
    Formulario (
        peso = 40.0,
        cantou = false,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario (
        peso = 42.0,
        cantou = true,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario (
        peso = 44.0,
        cantou = true,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    )
)
