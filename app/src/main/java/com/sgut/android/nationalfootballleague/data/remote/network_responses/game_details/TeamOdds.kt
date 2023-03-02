package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class TeamOdds (

  @SerializedName("preMatchMoneyLineAway"      ) var preMatchMoneyLineAway      : PreMatchMoneyLineAway?      = PreMatchMoneyLineAway(),
  @SerializedName("preMatchMoneyLineHome"      ) var preMatchMoneyLineHome      : PreMatchMoneyLineHome?      = PreMatchMoneyLineHome(),
  @SerializedName("preMatchSpreadHandicapAway" ) var preMatchSpreadHandicapAway : PreMatchSpreadHandicapAway? = PreMatchSpreadHandicapAway(),
  @SerializedName("preMatchSpreadHome"         ) var preMatchSpreadHome         : PreMatchSpreadHome?         = PreMatchSpreadHome(),
  @SerializedName("preMatchWinningMarginHome"  ) var preMatchWinningMarginHome  : PreMatchWinningMarginHome?  = PreMatchWinningMarginHome(),
  @SerializedName("preMatchTotalOver"          ) var preMatchTotalOver          : PreMatchTotalOver?          = PreMatchTotalOver(),
  @SerializedName("preMatchWinningMarginOther" ) var preMatchWinningMarginOther : PreMatchWinningMarginOther? = PreMatchWinningMarginOther(),
  @SerializedName("preMatchSpreadAway"         ) var preMatchSpreadAway         : PreMatchSpreadAway?         = PreMatchSpreadAway(),
  @SerializedName("preMatchWinningMarginAway"  ) var preMatchWinningMarginAway  : PreMatchWinningMarginAway?  = PreMatchWinningMarginAway(),
  @SerializedName("preMatchTotalUnder"         ) var preMatchTotalUnder         : PreMatchTotalUnder?         = PreMatchTotalUnder(),
  @SerializedName("preMatchTotalHandicap"      ) var preMatchTotalHandicap      : PreMatchTotalHandicap?      = PreMatchTotalHandicap(),
  @SerializedName("preMatchSpreadHandicapHome" ) var preMatchSpreadHandicapHome : PreMatchSpreadHandicapHome? = PreMatchSpreadHandicapHome()

)