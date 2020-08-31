package com.blimas.desafiotimelineandroid.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

open class FormatValues {

    companion object{

        fun formatMoneyText(value: Double): String {
            val ptBr = Locale("pt", "BR")
            return NumberFormat.getCurrencyInstance(ptBr).format(value)
        }

        fun formatTextoMes(mes: Int): String {
            val local = Locale("pt", "BR")
            val monthDate = SimpleDateFormat("MMM", local)
            val sdf = SimpleDateFormat("MM", local)

            val date = sdf.parse(mes.toString());
            val mes = monthDate.format(date);
            return mes.toUpperCase()
        }
    }

}