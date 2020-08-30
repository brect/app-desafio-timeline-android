package com.blimas.desafiotimelineandroid.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import java.text.NumberFormat
import java.util.*

class LancamentosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mTextOrigem: TextView = itemView.findViewById(R.id.text_origem)
    private var mTextValor: TextView = itemView.findViewById(R.id.text_valor)

    fun bindData(lancamentoModel: LancamentoModel) {

        this.mTextOrigem.text = lancamentoModel.origem
        this.mTextValor.text = formatMoneyText(lancamentoModel.valor)

    }

    private fun formatMoneyText(value: Double): String {
        val value = value
        val ptBr = Locale("pt", "BR")
        return NumberFormat.getCurrencyInstance(ptBr).format(value)
    }
}