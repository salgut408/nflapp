package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsImages(

    @SerializedName("name")
    val name: String? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("alt")
    val alt: String? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("href")
    val href: String? = null,


    )