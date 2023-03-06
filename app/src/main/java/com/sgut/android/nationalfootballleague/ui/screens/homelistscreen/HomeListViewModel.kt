package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuthException
import com.sgut.android.nationalfootballleague.data.repository.EspnRepositoryImpl
import com.sgut.android.nationalfootballleague.data.repository.TeamsListRepositoryImpl
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDomainModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.EPL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.HOCKEY
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.LA_LIGA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLB
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NFL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NHL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SOCCER
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.UEFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WNBA
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val accountService: AccountService,
    private val espnRepository: EspnRepositoryImpl,
    private val fullTeamsListRepository: TeamsListRepositoryImpl
) : ViewModel() {

    private val _ListUiState = MutableStateFlow(ListUiState())
    val listUiState: StateFlow<ListUiState> = _ListUiState.asStateFlow()

    val nflTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val collegeTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val baseballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val hockeyTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val basketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val soccerTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val womensBasketballTeamsList = mutableStateOf<List<TeamDomainModel>>(listOf())
    val worldCupTeams = mutableStateOf<List<TeamDomainModel>>(listOf())
    val collegeBasketballTeams = mutableStateOf<List<TeamDomainModel>>(listOf())
    val laLigaTeams = mutableStateOf<List<TeamDomainModel>>(listOf())
    val englishTeams = mutableStateOf<List<TeamDomainModel>>(listOf())
    val euroTeams = mutableStateOf<List<TeamDomainModel>>(listOf())

    lateinit var completeNflInfo : FullTeamsModel
//    val holderForFullTeamInfo = mutableStateOf(FullTeamsModel())
    lateinit var _completeInfoForState : FullTeamsModel

    // TODO FIX UI STATE UPDATE

    init {
        loadCompleteNflInfo()
        loadAllNflTeams()
        Log.d("GUTIERREZ ", listUiState.value.fullTeamInfo.toString())

        loadAllCollegeTeams()
        loadAllBaseballTeams()
        loadAllBasketballTeams()
        loadAllSoccerTeams()
        loadAllWomensBasketballTeams()
        loadAllHockeyTeams()
        loadWorldCupTeams()
        loadCollegeBasketballTeams()
        setAccount()
        loadEnglishTeams()
        loadLaLigaTeams()
        loadEuroTeams()

    }

    fun addTeamsToDb(team: List<TeamDomainModel>) = viewModelScope.launch {
        espnRepository.storeTeamsInSportsDatabase(team)
    }

    fun callForCompleteTeamAndLeagueInfo(sport: String, league: String) = viewModelScope.launch {
        fullTeamsListRepository.getFullSportLeagueAndTeamsList(sport, league)
    }

    fun loadCompleteNflInfo() = viewModelScope.launch {
        try {
           val result = espnRepository.getFullSportLeagueNflTeams()
            val tagHomeVm = "Complete full  teams response in homelist Vm"
//            Log.d(tagHomeVm, result.sports.toString())
            completeNflInfo = result
        }  catch (e: Exception){
            val tagHomeVm = "Complete full  teams response in homelist Vm"
//            Log.e(tagHomeVm, e.toString())
        }
    }

    fun loadCompleteInfo(sport: String, league: String) = viewModelScope.launch {
//       val fullInfo = espnRepository.getFullTeamInfo(sport, league)
//
//        _completeInfoForState = fullInfo
    }

    fun loadEuroTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getLaLigaSoccerTeams()
            euroTeams.value = result
            addTeamsToDb(result)
        } catch (e: Exception) {
            Log.e("Euro", e.message.toString())
        }
    }

    fun loadLaLigaTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getLaLigaSoccerTeams()
            laLigaTeams.value = result
            addTeamsToDb(result)
        } catch (e: Exception) {
            Log.e("Liga", e.message.toString())
        }
    }

    fun loadEnglishTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllEnglishSoccerTeams()
            englishTeams.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.e("Eng", e.message.toString())
        }
    }

    fun loadAllBaseballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllBaseballTeams()
            baseballTeamsList.value = result
            addTeamsToDb(result)
        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }


    fun loadAllNflTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getTeams()
            nflTeamsList.value = result
            val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NFL)
            _completeInfoForState = fullTeam
//            Default list Ui State set here
            _ListUiState.update { currentState ->
                currentState.copy(
                    currentTeams = result,
                    currentSport = "football",
                    currentLeague = "nfl",
                    fullTeamInfo =  _completeInfoForState
                )
            }
            Log.d("_completeInfo", _completeInfoForState.toString())
        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }

    fun loadAllCollegeTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllCollegeTeams()
            collegeTeamsList.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.i("tag", e.message.toString())

        }
    }

    fun loadAllHockeyTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllHockeyTeams()
            hockeyTeamsList.value = result
            addTeamsToDb(result)


        } catch (e: Exception) {
            Log.i("tag", e.message.toString())

        }
    }

    fun loadAllBasketballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllBasketballTeams()
            basketballTeamsList.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }

    fun loadAllSoccerTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllSoccerTeams()
            soccerTeamsList.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }

    fun loadWorldCupTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllWorldCupTeams()
            worldCupTeams.value = result
        } catch (e: Exception) {
            Log.e("tag", e.message.toString())
        }
    }

    fun loadAllWomensBasketballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllWomensBasketballTeams()
            womensBasketballTeamsList.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }

    fun loadCollegeBasketballTeams() = viewModelScope.launch {
        try {
            val result = espnRepository.getAllCollegeBasketballTeams()
            collegeBasketballTeams.value = result
            addTeamsToDb(result)

        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
        }
    }




    fun setLaLigaTeams() = viewModelScope.launch{
        _ListUiState.update {
            val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, LA_LIGA)

            it.copy(
                currentTeams = laLigaTeams.value,
                currentSport = "soccer",
                currentLeague = "esp.1",
                fullTeamInfo = fullTeam,
            )
        }
    }

    fun setEnglishTeams() = viewModelScope.launch {
        _ListUiState.update {
            val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, EPL)

            it.copy(
                currentTeams = englishTeams.value,
                currentSport = "soccer",
                currentLeague = "eng.1",
                fullTeamInfo = fullTeam
            )
        }
    }

    fun setEuroTeams() = viewModelScope.launch() {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, UEFA)

        _ListUiState.update {
            it.copy(
                currentTeams = euroTeams.value,
                currentSport = "soccer",
                currentLeague = "uefa.europa",
                fullTeamInfo = fullTeam
            )
        }
    }


    fun setBaseballTeam() = viewModelScope.launch {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASEBALL, MLB)
        _ListUiState.update {
            it.copy(
                currentTeams = baseballTeamsList.value,
                currentSport = "baseball",
                currentLeague = "mlb",
                fullTeamInfo = fullTeam
            )
        }

    }

    fun setCollegeBasketballTeam() = viewModelScope.launch{
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, NCAA_BASKETBALL)

        _ListUiState.update {

            it.copy(
                currentTeams = collegeBasketballTeams.value,
                currentSport = "basketball",
                currentLeague = "mens-college-basketball",
                fullTeamInfo = fullTeam
            )
        }
    }

    fun setBasketballTeam() = viewModelScope.launch {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, NBA)

        _ListUiState.update {
            it.copy(
                currentTeams = basketballTeamsList.value,
                currentSport = "basketball",
                currentLeague = "nba",
                fullTeamInfo = fullTeam,
            )
        }
    }

    fun setFootballTeam() = viewModelScope.launch{
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NFL)

        _ListUiState.update {
            it.copy(
                currentTeams = nflTeamsList.value,
                currentSport = "football",
                currentLeague = "nfl",
                fullTeamInfo = fullTeam
            )
        }
    }


    fun setHockeyTeam() = viewModelScope.launch {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(HOCKEY, NHL)

        _ListUiState.update {
            it.copy(
                currentTeams = hockeyTeamsList.value,
                currentSport = "hockey",
                currentLeague = "nhl",
                fullTeamInfo = fullTeam
            )
        }
    }

    fun setWnbaTeam() = viewModelScope.launch{
        _ListUiState.update {
            val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, WNBA)

            it.copy(
                currentTeams = womensBasketballTeamsList.value,
                currentSport = "basketball",
                currentLeague = "wnba",
                fullTeamInfo = fullTeam
            )
        }
    }

    fun setMlsTeam() = viewModelScope.launch {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, MLS)

        _ListUiState.update {
            it.copy(
                currentTeams = soccerTeamsList.value,
                currentSport = "soccer",
                currentLeague = "usa.1",
                fullTeamInfo = fullTeam,
            )
        }
    }

    fun setCollegeTeam() = viewModelScope.launch {
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NCAA_FOOTBALL)

        _ListUiState.update {
            it.copy(
                currentTeams = collegeTeamsList.value,
                currentSport = "football",
                currentLeague = "college-football",
                fullTeamInfo = fullTeam
            )
        }
    }

    fun setWorldCupTeam() = viewModelScope.launch{
        val fullTeam = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, FIFA)

        _ListUiState.update {
            it.copy(
                currentTeams = worldCupTeams.value,
                currentSport = "soccer",
                currentLeague = "fifa.world",
                fullTeamInfo = fullTeam
            )
        }
    }



    fun setAccount() = viewModelScope.launch {
        if (!accountService.hasUser) {
            createAnonymousAccount()
        }
    }

    private fun createAnonymousAccount() = viewModelScope.launch {
        try {
            accountService.createAnonymousAccount()
        } catch (ex: FirebaseAuthException) {
            throw ex
        }
    }
}