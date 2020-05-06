package com.rosario.testfalabella.data.model

import java.io.Serializable

data class Indicator(
    val codigo: String = "",
    val nombre: String = "",
    val unidad_medida: String = "",
    val fecha: String = "",
    val valor: Double = 0.0
): Serializable