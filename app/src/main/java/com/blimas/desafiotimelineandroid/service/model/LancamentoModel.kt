package com.blimas.desafiotimelineandroid.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LancamentoModel(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("valor")
    var valor: Double = 0.0,

    @SerializedName("origem")
    var origem: String = "",

    @SerializedName("categoria")
    var categoria: Int = 0,

    @SerializedName("mes_lancamento")
    var mes_lancamento: Int = 0
) : Parcelable