package com.blimas.desafiotimelineandroid.service.model

import com.google.gson.annotations.SerializedName

class LancamentoModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("valor")
    var valor: Float = 0.0F

    @SerializedName("origem")
    var origem: String = ""

    @SerializedName("categoria")
    var categoria: Int = 0

    @SerializedName("mes_lancamento")
    var mes_lancamento: Int = 0

}