package com.blimas.desafiotimelineandroid.utils

import java.text.NumberFormat
import java.util.*

open class FormatValues {

    companion object{
        fun formatMoneyText(value: Double): String {
            val ptBr = Locale("pt", "BR")
            return NumberFormat.getCurrencyInstance(ptBr).format(value)
        }
    }

}