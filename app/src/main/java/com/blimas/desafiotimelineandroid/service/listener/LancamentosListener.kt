package com.blimas.desafiotimelineandroid.service.listener

import com.blimas.desafiotimelineandroid.service.model.LancamentoModel

interface LancamentosListener {

    /**
     * Click para edição
     */
    fun onItemClick(param: LancamentoModel)

}