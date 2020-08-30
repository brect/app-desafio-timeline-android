package com.blimas.desafiotimelineandroid.service.repository.remote

import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import retrofit2.Call
import retrofit2.http.GET

interface LancamentoService {

    @GET("lancamentos")
    fun all(): Call<List<LancamentoModel>>

}