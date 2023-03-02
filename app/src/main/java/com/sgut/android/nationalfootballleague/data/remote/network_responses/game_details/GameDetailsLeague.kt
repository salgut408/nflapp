package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLeague(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("name") var name: String = "",
    @SerializedName("abbreviation") var abbreviation: String = "",



//  @SerializedName("links"       ) var links       : List<GameDetailsLinks>  = listOf()

)