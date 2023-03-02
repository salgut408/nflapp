package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*


data class Videos (

    @SerializedName("source"              ) var source              : String?             = null,
    @SerializedName("id"                  ) var id                  : Int?                = null,
    @SerializedName("headline"            ) var headline            : String?             = null,
    @SerializedName("description"         ) var description         : String?             = null,
    @SerializedName("ad"                  ) var ad                  : Ad?                 = Ad(),
    @SerializedName("tracking"            ) var tracking            : Tracking?           = Tracking(),
    @SerializedName("cerebroId"           ) var cerebroId           : String?             = null,
    @SerializedName("lastModified"        ) var lastModified        : String?             = null,
    @SerializedName("originalPublishDate" ) var originalPublishDate : String?             = null,
    @SerializedName("timeRestrictions"    ) var timeRestrictions    : TimeRestrictions?   = TimeRestrictions(),
    @SerializedName("deviceRestrictions"  ) var deviceRestrictions  : DeviceRestrictions? = DeviceRestrictions(),
    @SerializedName("duration"            ) var duration            : Int?                = null,
    @SerializedName("thumbnail"           ) var thumbnail           : String?             = null,
    @SerializedName("links"               ) var links               : GameDetailsLinks?              = GameDetailsLinks()

)