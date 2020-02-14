package com.example.cryptocoin.model

data class TopWisataResponse(
    val status_code:Int,
    val message:String,
    val data:List<WisataModel>
)