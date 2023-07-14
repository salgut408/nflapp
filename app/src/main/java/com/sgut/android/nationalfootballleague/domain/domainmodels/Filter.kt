package com.sgut.android.nationalfootballleague.domain.domainmodels

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.sgut.android.nationalfootballleague.utils.Constants
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.CFL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.CHAMPIONS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.EPL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.HOCKEY
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.LACROSSE
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.LA_LIGA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLB
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_HOCKEY
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_LACROSSE
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NFL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NHL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SOCCER
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.UEFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WBC
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WNBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.XFL

@Stable
class Filter(
    val league: String,
    val sport: String,
    val displayName: String,
    enabled: Boolean = false,
    val icon: ImageVector? = null,
) {
    val enabled = mutableStateOf(enabled)
}

val filters = listOf(
    Filter(
        league = MLB,
        sport = BASEBALL,
        displayName = "MLB"
    ),
    Filter(
        league = NFL,
        sport = FOOTBALL,
        displayName = "NFL"
    ),



    Filter(
        league = NBA,
        sport = BASKETBALL,
        displayName = "NBA"
    ),
    Filter(
        league = NHL,
        sport = HOCKEY,
        displayName = "NHL"
    ),
    Filter(
        league = XFL,
        sport = FOOTBALL,
        displayName = "XFL"
    ),
    Filter(
        league = CFL,
        sport = FOOTBALL,
        displayName = "CFL"
    ),


    Filter(
        league = WBC,
        sport = BASEBALL,
        displayName = "WBC"
    ),
    Filter(
        league = WNBA,
        sport = BASKETBALL,
        displayName = "WNBA"
    ),
    //soccer
    Filter(
        league = CHAMPIONS,
        sport = SOCCER,
        displayName = "Champions"
    ),
    Filter(
        league = MLS,
        sport = SOCCER,
        displayName = "MLS"
    ),
    Filter(
        league = Constants.FRA,
        sport = SOCCER,
        displayName = "FRA"
    ),
    Filter(
        league = LA_LIGA,
        sport = SOCCER,
        displayName = "La Liga"
    ),
    Filter(
        league = FIFA,
        sport = SOCCER,
        displayName = "FIFA"
    ),
    Filter(
        league = EPL,
        sport = SOCCER,
        displayName = "FRA"
    ),
    Filter(
        league = UEFA,
        sport = SOCCER,
        displayName = "UEFA"
    ),

    // college
    Filter(
        league = NCAA_FOOTBALL,
        sport = FOOTBALL,
        displayName = "NCAA Football"
    ),
    Filter(
        league = NCAA_BASEBALL,
        sport = BASEBALL,
        displayName = "NCAA Baseball"
    ),
    Filter(
        league = NCAA_BASKETBALL,
        sport = BASKETBALL,
        displayName = "NCAA Basketball"
    ),
    Filter(
        league = NCAA_HOCKEY,
        sport = HOCKEY,
        displayName = "NCAA Hockey"
    ),
    Filter(
        league = NCAA_LACROSSE,
        sport = LACROSSE,
        displayName = "NCAA Basketball"
    ),




)
//Fake repository for filters
object FilterRepo {
    fun getFilters() = filters
}