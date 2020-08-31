package com.blimas.desafiotimelineandroid.service.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GastoModel (
    var mes: Int = 0,
    var valor: List<LancamentoModel>
) : Parcelable