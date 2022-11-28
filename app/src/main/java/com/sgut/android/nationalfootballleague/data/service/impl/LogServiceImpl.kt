package com.sgut.android.nationalfootballleague.data.service.impl

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.sgut.android.nationalfootballleague.data.service.LogService
import javax.inject.Inject

class LogServiceImpl @Inject constructor(): LogService {
    override fun logNonFatalCrash(throwable: Throwable) =
       Firebase.crashlytics.recordException(throwable)

}