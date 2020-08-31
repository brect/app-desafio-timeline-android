package com.blimas.desafiotimelineandroid.service.repository

import android.content.Context
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants
import com.blimas.desafiotimelineandroid.service.listener.ApiListener
import com.blimas.desafiotimelineandroid.service.model.CategoriasModel
import com.blimas.desafiotimelineandroid.service.repository.remote.CategoriaService
import com.blimas.desafiotimelineandroid.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriasRepository (val context: Context) {

    private var mRemote = RetrofitClient.createService(CategoriaService::class.java)

    fun getAll(listener: ApiListener<List<CategoriasModel>>) {

        val call: Call<List<CategoriasModel>> = mRemote.all()

        call.enqueue(object : Callback<List<CategoriasModel>> {
            override fun onFailure(call: Call<List<CategoriasModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(
                call: Call<List<CategoriasModel>>,
                response: Response<List<CategoriasModel>>
            ) {
                if (response.code() != ApplicationConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }
        })
    }


}