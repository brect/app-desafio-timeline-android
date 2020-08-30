package com.blimas.desafiotimelineandroid.service.repository.remote

import com.blimas.desafiotimelineandroid.service.model.CategoriasModel
import retrofit2.Call
import retrofit2.http.GET

interface CategoriaService {

    @GET("categorias")
    fun listarCategorias(): Call<List<CategoriasModel>>

}