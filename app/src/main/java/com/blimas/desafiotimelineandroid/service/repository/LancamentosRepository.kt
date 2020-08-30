package com.blimas.desafiotimelineandroid.service.repository

import android.content.Context
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants
import com.blimas.desafiotimelineandroid.service.listener.ApiListener
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.service.repository.remote.LancamentoService
import com.blimas.desafiotimelineandroid.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LancamentosRepository (val context: Context) {

    private var mRemote = RetrofitClient.createService(LancamentoService::class.java)

    fun getAll(listener: ApiListener<List<LancamentoModel>>) {

        val call: Call<List<LancamentoModel>> = mRemote.all()

        call.enqueue(object : Callback<List<LancamentoModel>> {
            override fun onFailure(call: Call<List<LancamentoModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(
                call: Call<List<LancamentoModel>>,
                response: Response<List<LancamentoModel>>
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
