package com.blimas.desafiotimelineandroid.service.listener

interface ApiListener<T> {

    fun onSuccess(param: T)
    fun onFailure(msg: String)

}