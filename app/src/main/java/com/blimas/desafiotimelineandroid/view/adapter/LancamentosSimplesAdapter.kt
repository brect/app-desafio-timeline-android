package com.blimas.desafiotimelineandroid.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.view.viewholder.LancamentoSimplesViewHolder

class LancamentosSimplesAdapter : RecyclerView.Adapter<LancamentoSimplesViewHolder>() {

    private var mList: List<LancamentoModel> = arrayListOf()
    private lateinit var mListener: LancamentosListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LancamentoSimplesViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_lancamento_simples, parent, false)
        return LancamentoSimplesViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: LancamentoSimplesViewHolder, position: Int) {
        holder.bindData(mList[position])
    }

    fun attachListener(listener: LancamentosListener) {
        mListener = listener
    }

    fun updateListener(list: List<LancamentoModel>) {
        mList = list
        notifyDataSetChanged()
    }

}