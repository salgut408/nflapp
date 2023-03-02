package com.sgut.android.nationalfootballleague.domain.dtomappers


interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
}