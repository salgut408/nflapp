package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsInjuries(

  @SerializedName("team") var team: InjTeam? = InjTeam(),
  @SerializedName("injuries") var injuries: List<InjuriesItem> = listOf(),

  )

data class InjTeam(
  @SerializedName("id") var id: String = "",
  @SerializedName("uid") var uid: String = "",
  @SerializedName("displayName") var displayName: String = "",
  @SerializedName("logo") var logo: String = "",


  )

data class InjuriesItem(
  @SerializedName("status") var status: String = "",
  @SerializedName("date") var date: String = "",
  @SerializedName("athlete") var athlete: GameDetailsAthlete = GameDetailsAthlete(),
  @SerializedName("type") var type: GameDetailsType = GameDetailsType(),




  )