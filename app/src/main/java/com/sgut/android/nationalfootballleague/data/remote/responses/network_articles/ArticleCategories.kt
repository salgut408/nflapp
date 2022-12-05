package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class ArticleCategories (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("type"        ) var type        : String? = null,
  @SerializedName("sportId"     ) var sportId     : Int?    = null,
  @SerializedName("leagueId"    ) var leagueId    : Int?    = null,
  @SerializedName("league"      ) var league      : ArticleLeague? = ArticleLeague(),
  @SerializedName("uid"         ) var uid         : String? = null,
  @SerializedName("createDate"  ) var createDate  : String? = null

)