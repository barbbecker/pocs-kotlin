package com.barbbecker.fundatec.proconapp

import com.google.gson.annotations.SerializedName


data class Procon(
    @SerializedName("empresasMaisReclamadas")
    val empresasMaisReclamadas: List<EmpresasMaisReclamada>
)

data class EmpresasMaisReclamada(
    @SerializedName("empresa")
    val empresa: String,
    @SerializedName("qtde")
    val qtde: String


) {
    override fun toString(): String {
        return empresa + ": " + qtde
    }
}






