package com.sgut.android.nationalfootballleague.gamedetailscreen

import androidx.lifecycle.ViewModel
import com.sgut.android.nationalfootballleague.data.repository.EspnRepository
import javax.inject.Inject

class GameDetailViewModel @Inject constructor(
    private val espnRepository: EspnRepository
): ViewModel(){
}