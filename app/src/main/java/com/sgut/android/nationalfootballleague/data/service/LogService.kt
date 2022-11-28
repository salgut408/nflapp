package com.sgut.android.nationalfootballleague.data.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}