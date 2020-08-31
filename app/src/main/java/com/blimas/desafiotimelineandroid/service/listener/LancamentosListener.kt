package com.blimas.desafiotimelineandroid.service.listener

import com.blimas.desafiotimelineandroid.service.model.LancamentoModel

interface LancamentosListener {

    fun onItemClick(param: LancamentoModel)

}