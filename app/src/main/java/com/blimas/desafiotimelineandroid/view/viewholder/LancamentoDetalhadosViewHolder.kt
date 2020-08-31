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

    var mContainerTituloMes: ConstraintLayout =
        itemView.findViewById(R.id.container_titulo_mes)
    private var mTextTituloMes: TextView = itemView.findViewById(R.id.text_titulo_mes)
    private var mTextTituloValorMes: TextView = itemView.findViewById(R.id.text_titulo_valor)

    var mTextMes: TextView = itemView.findViewById(R.id.text_mes)
    private var mTextOrigem: TextView = itemView.findViewById(R.id.text_origem)
    private var mTextValor: TextView = itemView.findViewById(R.id.text_valor)

    fun bindData(
        lancamento: LancamentoModel
    ) {
        this.mTextMes.text = FormatValues.formatTextoMes(lancamento.mes_lancamento)
        this.mTextOrigem.text = lancamento.origem
        this.mTextValor.text = FormatValues.formatMoneyText(lancamento.valor)
        mContainerTituloMes.visibility = View.GONE

        mContainerItem.setOnClickListener { listener.onItemClick(lancamento) }
    }


    fun bindDataTituloMes(lancamento: LancamentoModel, mGroupList: Map<Int, Double>) {
        val value = mGroupList[lancamento.mes_lancamento]?.let {
            FormatValues.formatMoneyText(
                it
            )
        }
        mTextTituloMes.text = FormatValues.formatTextoMes(lancamento.mes_lancamento)
        mTextTituloValorMes.text = value
    }

    fun setVisibilityContainerTituloMes(view: Int) {
        mContainerTituloMes.visibility = view
    }
}
