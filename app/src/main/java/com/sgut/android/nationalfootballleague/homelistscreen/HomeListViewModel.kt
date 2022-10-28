package com.sgut.android.nationalfootballleague.homelistscreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.repository.NflRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val nflRepository: NflRepository
) : ViewModel() {

    var teamsList = mutableStateOf<List<TeamDomainModel>>(listOf())

    init {
        loadAllTeams()
    }

    fun loadAllTeams() = viewModelScope.launch {
        try {
            val result = nflRepository.getNflTeams()
            teamsList.value = result
            Log.i("tag", result.toString())
        } catch (e: Exception) {
            Log.i("tag",e.message.toString())
        }
    }
}