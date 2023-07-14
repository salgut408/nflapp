package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class HeadlinesNetworkResponse(

    @SerializedName("dataSourceIdentifier")
    val dataSourceIdentifier: String = "",
    @SerializedName("keywords")
    val keywords: ArrayList<String> = arrayListOf(),
    @SerializedName("description")
    val description: String = "",
    @SerializedName("source")
    val source: String = "",
    @SerializedName("video")
    val video: ArrayList<Video> = arrayListOf(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("links")
    val links: Links? = Links(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("headline")
    val headline: String = "",
    @SerializedName("originallyPosted")
    val originallyPosted: String = "",
//    @SerializedName("images"               ) val images               : ArrayList<Images>     = arrayListOf(),
    @SerializedName("published")
    val published: String = "",
    @SerializedName("lastModified")
    val lastModified: String = "",
    @SerializedName("story")
    val story: String = "",

    )
