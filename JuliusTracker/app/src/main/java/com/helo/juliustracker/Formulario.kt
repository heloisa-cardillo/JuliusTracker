package com.helo.juliustracker

data class Formulario (
   var peso: Double,
   var cantou: Boolean,
   var quantidadepapa: Int,
   var comeuracao: Boolean,
   var remedios: List<Medicine>
)


data class Medicine (
    var nomeremedio: String,
    var vezesaodia: Int,
    var quantidade: Double)

val items = listOf (
    Formulario (
        peso = 10.0,
        cantou = false,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario (
        peso = 10.0,
        cantou = false,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    ),
    Formulario (
        peso = 10.0,
        cantou = false,
        quantidadepapa = 150,
        comeuracao = true,
        remedios = emptyList()
    )
)
