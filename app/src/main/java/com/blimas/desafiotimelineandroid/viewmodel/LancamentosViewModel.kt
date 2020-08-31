package com.blimas.desafiotimelineandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blimas.desafiotimelineandroid.service.listener.ApiListener
import com.blimas.desafiotimelineandroid.service.listener.ValidationListener
import com.blimas.desafiotimelineandroid.service.model.CategoriasModel
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.service.repository.CategoriasRepository
import com.blimas.desafiotimelineandroid.service.repository.LancamentosRepository

class LancamentosViewModel(application: Application) : AndroidViewModel(application) {

    private val mLancamentosRepository = LancamentosRepository(application)
    private val mCategoriasRepository = CategoriasRepository(application)

    private val mLancamentosList = MutableLiveData<List<LancamentoModel>>()
    var lancamentos: LiveData<List<LancamentoModel>> = mLancamentosList

    private val mCategoriasList = MutableLiveData<List<CategoriasModel>>()
    var categorias: LiveData<List<CategoriasModel>> = mCategoriasList

    private val mGastosList = MutableLiveData<Map<Int, Double>>()
    var gastos: LiveData<Map<Int, Double>> = mGastosList

    private val mBalancoGastosList = MutableLiveData<Map<Int, List<LancamentoModel>>>()
    var balancoGastos: LiveData<Map<Int, List<LancamentoModel>>> = mBalancoGastosList

    private val mValidationListener = MutableLiveData<ValidationListener>()
    var validation: LiveData<ValidationListener> = mValidationListener

    fun getLancamentos() {
        mLancamentosRepository.getAll(object : ApiListener<List<LancamentoModel>> {
            override fun onSuccess(param: List<LancamentoModel>) {
                mLancamentosList.value = param
            }

            override fun onFailure(msg: String) {
                mLancamentosList.value = arrayListOf()
                mValidationListener.value = ValidationListener(msg)
            }
        })
    }

    fun getCategorias() {
        mCategoriasRepository.getAll(object : ApiListener<List<CategoriasModel>> {
            override fun onSuccess(param: List<CategoriasModel>) {
                mCategoriasList.value = param
            }

            override fun onFailure(msg: String) {
                mCategoriasList.value = arrayListOf()
                mValidationListener.value = ValidationListener(msg)
            }
        })
    }

    fun getGastosMensais(lancamentos: List<LancamentoModel>) {
        mGastosList.value = lancamentos.groupBy { it.mes_lancamento }.mapValues { it -> it.value.sumByDouble { it.valor }}

    }

    fun getBalancoGastosMensais(lancamentos: List<LancamentoModel>) {
        mBalancoGastosList.value = lancamentos.groupBy { it.mes_lancamento }
    }
}