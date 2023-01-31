package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleDetailNetworkResponse (

    @SerializedName("resultsOffset" ) var resultsOffset : Int?                 = null,
    @SerializedName("resultsCount"  ) var resultsCount  : Int?                 = null,
//    @SerializedName("headlines"     ) var headlines     : ArrayList<Headlines> = arrayListOf(),
    @SerializedName("resultsLimit"  ) var resultsLimit  : Int?                 = null,
    @SerializedName("timestamp"     ) var timestamp     : String?              = null,
    @SerializedName("status"        ) var status        : String?              = null

)
