package com.sgut.android.nationalfootballleague.ui.screens.selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.SportModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SelectionViewModel @Inject constructor(
    private val fullTeamsListRepository: TeamsListsRepository,
    private val getArticles: GetArticlesUseCase,
): ViewModel() {
    private val _selectionUiState = MutableStateFlow(SportModel())
    val selectionUiState: StateFlow<SportModel> = _selectionUiState.asStateFlow()

    private val _articleList = MutableStateFlow(ArticlesListModel())
    val articleList: StateFlow<ArticlesListModel> = _articleList.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

     suspend fun loadSport(sport: String, league: String) {
         viewModelScope.launch {

             val sportModel =  fullTeamsListRepository.getSport(sport, league)
             loadNews(sport, league)

             _selectionUiState.update {
                 it.copy(
                     id = sportModel.id,
                     uid = sportModel.uid,
                     name = sportModel.name,
                     slug = sportModel.slug,
                     league = sportModel.league
                 )
             }
             Timber.d("SAL_GUT SPORT SELECTED: ${selectionUiState.value}")
         }
    }

    fun setDifferentSport(sport: String, league: String) = viewModelScope.launch {
        loadSport(sport, league)
        loadNews(sport, league)
    }

    private suspend fun loadNews(sport: String, league: String) {
       _articleList.value = getArticles(sport, league)
    }




}