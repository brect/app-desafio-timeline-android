package com.blimas.desafiotimelineandroid.service.repository.remote

import retrofit2.http.GET

interface CategoriaService {

    @GET("categorias")
    fun lancamentos()

}