package com.helo.juliustracker

open class FormularioActivity (
    peso: Double,
    cantou: Boolean,
    comeuracao: Boolean, nomeremedio: String, vezesaodia: Int, quantidade: Double
):
    MedicinesListFragment (nomeremedio, vezesaodia, quantidade,) {

}


fun FormularioActivity(){
    val x = FormularioActivity()
    println(x)
}

