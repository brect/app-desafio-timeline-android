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

    private val mValidationListener = MutableLiveData<ValidationListener>()
    var validation: LiveData<ValidationListener> = mValidationListener

    fun getAllReleases(){
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

    fun getAllCategories(){
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

}