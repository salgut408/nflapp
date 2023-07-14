package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleDetailNetworkResponse(

    @SerializedName("resultsOffset")
    val resultsOffset: Int = 0,
    @SerializedName("resultsCount")
    val resultsCount:  Int = 0,
//    @SerializedName("headlines"     )
//    val headlines     : ArrayList<Headlines> = arrayListOf(),
    @SerializedName("resultsLimit")
    val resultsLimit:  Int = 0,
    @SerializedName("timestamp")
    val timestamp: String = "",
    @SerializedName("status")
    val status: String = "",

    )
