package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsInjuries (

  @SerializedName("team"     ) var team     : GameDetailsTeam?               = GameDetailsTeam(),
//  @SerializedName("injuries" ) var injuries : ArrayList<Injuries> = arrayListOf()

)