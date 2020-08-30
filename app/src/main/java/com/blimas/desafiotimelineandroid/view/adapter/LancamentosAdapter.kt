package com.blimas.desafiotimelineandroid.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.view.viewholder.LancamentosViewHolder

class LancamentosAdapter : RecyclerView.Adapter<LancamentosViewHolder>() {

    private var mList: List<LancamentoModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LancamentosViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_lancamentos_list, parent, false)
        return LancamentosViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: LancamentosViewHolder, position: Int) {
        holder.bindData(mList[position])
    }

    fun updateListener(list: List<LancamentoModel>) {
        mList = list
        notifyDataSetChanged()
    }

}