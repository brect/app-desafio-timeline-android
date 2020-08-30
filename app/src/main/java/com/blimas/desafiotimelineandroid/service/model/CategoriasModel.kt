package com.blimas.desafiotimelineandroid.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoriasModel (

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("nome")
    var nome: String = ""

) : Parcelable