package com.blimas.desafiotimelineandroid.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.service.model.CategoriasModel
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.view.viewholder.LancamentoDetalhadosViewHolder

class LancamentosDetalhadosAdapter : RecyclerView.Adapter<LancamentoDetalhadosViewHolder>() {

    private var mList: List<LancamentoModel> = arrayListOf()
    private lateinit var mListener: LancamentosListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LancamentoDetalhadosViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_lancamento_detalhado, parent, false)
        return LancamentoDetalhadosViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: LancamentoDetalhadosViewHolder, position: Int) {
        holder.bindData(mList[position])
    }

    fun attachListener(listener: LancamentosListener) {
        mListener = listener
    }

    fun updateListener(list: List<LancamentoModel>) {
        mList = list.sortedBy { it.mes_lancamento }
        notifyDataSetChanged()
    }


}