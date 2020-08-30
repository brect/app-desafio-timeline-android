package com.blimas.desafiotimelineandroid.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel

class LancamentosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mTextOrigem: TextView = itemView.findViewById(R.id.text_origem)

    fun bindData(lancamentoModel: LancamentoModel) {

        this.mTextOrigem.text = lancamentoModel.origem

    }
}