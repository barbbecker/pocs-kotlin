package com.example.tempopoa

import com.google.gson.annotations.SerializedName


data class Station(
    @SerializedName("data")
    val `data`: String,
    @SerializedName("alturaNuvens")
    val alturaNuvens: Int,
    @SerializedName("bairro")
    val bairro: String,
    @SerializedName("chuvaDiaria")
    val chuvaDiaria: Double,
    @SerializedName("direcaoVento")
    val direcaoVento: Int,
    @SerializedName("direcaoVentoRajada")
    val direcaoVentoRajada: Int,
    @SerializedName("endereco")
    val endereco: String,
    @SerializedName("estacao")
    val estacao: String,
    @SerializedName("iconePrevisao")
    val iconePrevisao: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("idRessonare")
    val idRessonare: Int,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("pontoOrvalho")
    val pontoOrvalho: Double,
    @SerializedName("pressao")
    val pressao: Double,
    @SerializedName("quadranteVento")
    val quadranteVento: String,
    @SerializedName("sensacaoTermica")
    val sensacaoTermica: Double,
    @SerializedName("temperaturaExterna")
    val temperaturaExterna: Double,
    @SerializedName("temperaturaInterna")
    val temperaturaInterna: Double,
    @SerializedName("temperaturaMaximaPrevisao")
    val temperaturaMaximaPrevisao: Double,
    @SerializedName("temperaturaMinimaPrevisao")
    val temperaturaMinimaPrevisao: Double,
    @SerializedName("umidadeExterna")
    val umidadeExterna: Int,
    @SerializedName("umidadeInterna")
    val umidadeInterna: Int,
    @SerializedName("velocidadeVento")
    val velocidadeVento: Int,
    @SerializedName("velocidadeVentoRajada")
    val velocidadeVentoRajada: Int


) {
    override fun toString(): String {
        return bairro + " - " + temperaturaExterna + " - Max " +
                temperaturaMaximaPrevisao + " min " + temperaturaMinimaPrevisao
    }
}