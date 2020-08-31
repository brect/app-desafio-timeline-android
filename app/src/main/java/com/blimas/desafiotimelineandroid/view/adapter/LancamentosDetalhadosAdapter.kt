package com.blimas.desafiotimelineandroid.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.utils.FormatValues
import com.blimas.desafiotimelineandroid.view.viewholder.LancamentoDetalhadosViewHolder

class LancamentosDetalhadosAdapter : RecyclerView.Adapter<LancamentoDetalhadosViewHolder>() {

    private var mList: List<LancamentoModel> = arrayListOf()
    private lateinit var mGroupList: Map<Int, Double>
    private lateinit var mBalanceGroupList: Map<Int, List<LancamentoModel>>
    private lateinit var mListener: LancamentosListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LancamentoDetalhadosViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_lancamento_detalhado, parent, false)
        return LancamentoDetalhadosViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: LancamentoDetalhadosViewHolder, position: Int) {

        holder.bindData(mList[position])

        when {
            position == 0 -> {
                holder.setVisibilityContainerTituloMes(View.VISIBLE)
                holder.bindDataTituloMes(mList[position], mGroupList)
            }
            holder.mTextMes.text != (FormatValues.formatTextoMes(mList[position - 1].mes_lancamento)) -> {
                holder.setVisibilityContainerTituloMes(View.VISIBLE)
                holder.bindDataTituloMes(mList[position], mGroupList)
            }
            else -> {
                holder.setVisibilityContainerTituloMes(View.GONE)
            }
        }
    }

    fun attachListener(listener: LancamentosListener) {
        mListener = listener
    }

    fun updateListener(list: List<LancamentoModel>) {
        mList = list.sortedBy { it.mes_lancamento }
        notifyDataSetChanged()
    }

    fun updateGroupListener(list: Map<Int, Double>) {
        mGroupList = list.toSortedMap()
        notifyDataSetChanged()
    }

    fun updateBalanceGroupListener(list: Map<Int, List<LancamentoModel>>) {
        mBalanceGroupList = list
        notifyDataSetChanged()
    }

}

