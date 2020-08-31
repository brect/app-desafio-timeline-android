package com.blimas.desafiotimelineandroid.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.utils.FormatValues


class LancamentoDetalhadosViewHolder(itemView: View, val listener: LancamentosListener) :
    RecyclerView.ViewHolder(itemView) {

    private var mContainerItem: ConstraintLayout =
        itemView.findViewById(R.id.container_item_lancamento)

    private var mTextMes: TextView = itemView.findViewById(R.id.text_mes)
    private var mTextOrigem: TextView = itemView.findViewById(R.id.text_origem)
    private var mTextValor: TextView = itemView.findViewById(R.id.text_valor)

    fun bindData(
        lancamentoModel: LancamentoModel
    ) {

        this.mTextMes.text = FormatValues.formatTextoMes(lancamentoModel.mes_lancamento)
        this.mTextOrigem.text = lancamentoModel.origem
        this.mTextValor.text = FormatValues.formatMoneyText(lancamentoModel.valor)

        mContainerItem.setOnClickListener { listener.onItemClick(lancamentoModel) }

    }

}