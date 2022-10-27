package com.sgut.android.nationalfootballleague.data.dtomappers


interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
}