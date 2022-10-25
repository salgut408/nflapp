package com.sgut.android.nationalfootballleague.data.dtomappers

import com.sgut.android.nationalfootballleague.Teams

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: Teams): DomainModel
}