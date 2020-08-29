package com.blimas.desafiotimelineandroid.service.repository.remote

import retrofit2.http.GET

interface LancamentoService {

    @GET("lancamentos")
    fun lancamentos()

}