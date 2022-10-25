package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.Links
import com.sgut.android.nationalfootballleague.Logos

data class TeamDomainModel(

var id               : String?          = null,
var uid              : String?          = null,
var slug             : String?          = null,
 var abbreviation     : String?          = null,
var displayName      : String?          = null,
var shortDisplayName : String?          = null,
var name             : String?          = null,
    var nickname         : String?          = null,
 var location         : String?          = null,
   var color            : String?          = null,
     var alternateColor   : String?          = null,
   var isActive         : Boolean?         = null,
    var isAllStar        : Boolean?         = null,
 var logos            : ArrayList<Logos>? = arrayListOf(),
) {
}