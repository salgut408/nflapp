package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class HeadlinesNetworkResponse(

    @SerializedName("dataSourceIdentifier") var dataSourceIdentifier: String? = null,
    @SerializedName("keywords") var keywords: ArrayList<String> = arrayListOf(),
    @SerializedName("description") var description: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("video") var video: ArrayList<Video> = arrayListOf(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("nowId") var nowId: String? = null,
    @SerializedName("premium") var premium: Boolean? = null,
//    @SerializedName("related"              ) var related              : ArrayList<Related>    = arrayListOf(),
    @SerializedName("allowSearch") var allowSearch: Boolean? = null,
    @SerializedName("links") var links: Links? = Links(),
    @SerializedName("id") var id: Int? = null,
//    @SerializedName("categories"           ) var categories           : ArrayList<Categories> = arrayListOf(),
    @SerializedName("headline") var headline: String? = null,
    @SerializedName("originallyPosted") var originallyPosted: String? = null,
//    @SerializedName("images"               ) var images               : ArrayList<Images>     = arrayListOf(),
    @SerializedName("allowCommerce") var allowCommerce: Boolean? = null,
    @SerializedName("linkText") var linkText: String? = null,
    @SerializedName("allowAMP") var allowAMP: Boolean? = null,
    @SerializedName("published") var published: String? = null,
    @SerializedName("allowComments") var allowComments: Boolean? = null,
    @SerializedName("allowAds") var allowAds: Boolean? = null,
    @SerializedName("lastModified") var lastModified: String? = null,
//    @SerializedName("metrics"              ) var metrics              : ArrayList<Metrics>    = arrayListOf(),
    @SerializedName("story") var story: String = "",

    )
