package com.rosario.testfalabella.data.model

data class IndicatorResponse (
    val version: String,
    val autor: String,
    val fecha: String,
    val uf: Indicator,
    val ivp: Indicator,
    val dolar: Indicator,
    val dolar_intercambio: Indicator,
    val euro: Indicator,
    val ipc: Indicator,
    val utm: Indicator,
    val imacec: Indicator,
    val tpm: Indicator,
    val libra_cobre: Indicator,
    val tasa_desempleo: Indicator,
    val bitcoin : Indicator
)