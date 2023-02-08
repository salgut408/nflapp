package com.sgut.android.nationalfootballleague.data.domainmodels

//TODO use this instead

sealed class SportState(val sport: String, val league: League){
    object BasketballNba: SportState("basketball", League.Nba)
    object FootballNfl: SportState("football", League.Nfl)
    object Hockey: SportState("hockey", League.Nhl)
    object Baseball: SportState("baseball", League.Mlb)
    object BasketballWnba: SportState("basketball", League.Wnba)
    object FootballNcaa: SportState("football", League.FootballNcaa)
    object BasketballNcaa: SportState("basketball", League.BasketballNcaa)

}

sealed class League(val league: String){
    object Nba: League( "nba")
    object Nfl: League( "nfl")
    object Nhl: League( "nhl")
    object Mlb: League( "mlb")
    object Wnba: League( "wnba")
    object FootballNcaa: League( "college-football")
    object BasketballNcaa: League( "mens-college-basketball")




}
