package com.fornity.sosmed.ui.list

import com.fornity.sosmed.network.ListResponse

interface ListContract {
    fun onSuccess( data: ListResponse)
    fun onFailed(msg:String)
}