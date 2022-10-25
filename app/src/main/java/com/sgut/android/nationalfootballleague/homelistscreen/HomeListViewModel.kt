package com.sgut.android.nationalfootballleague.homelistscreen

import androidx.lifecycle.ViewModel
import com.sgut.android.nationalfootballleague.repository.NflRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val nflRepository: NflRepository
) : ViewModel() {
}