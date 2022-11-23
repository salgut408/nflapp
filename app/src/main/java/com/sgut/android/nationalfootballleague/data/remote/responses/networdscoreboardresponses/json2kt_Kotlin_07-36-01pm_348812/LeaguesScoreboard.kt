package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class LeaguesScoreboard (

  @SerializedName("id"                  ) var id                  : String?             = null,
  @SerializedName("uid"                 ) var uid                 : String?             = null,
  @SerializedName("name"                ) var name                : String?             = null,
  @SerializedName("abbreviation"        ) var abbreviation        : String?             = null,
  @SerializedName("midsizeName"         ) var midsizeName         : String?             = null,
  @SerializedName("slug"                ) var slug                : String?             = null,
  @SerializedName("season"              ) var season              : SeasonScoreboard?             = SeasonScoreboard(),
  @SerializedName("logos"               ) var logos               : ArrayList<LogosScoreboard>    = arrayListOf(),
  @SerializedName("calendarType"        ) var calendarType        : String?             = null,
  @SerializedName("calendarIsWhitelist" ) var calendarIsWhitelist : Boolean?            = null,
  @SerializedName("calendarStartDate"   ) var calendarStartDate   : String?             = null,
  @SerializedName("calendarEndDate"     ) var calendarEndDate     : String?             = null,
  @SerializedName("calendar"            ) var calendar            : ArrayList<CalendarScoreboard> = arrayListOf()

)