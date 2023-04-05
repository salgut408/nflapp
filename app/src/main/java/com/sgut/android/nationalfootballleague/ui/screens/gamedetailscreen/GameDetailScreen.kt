package com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Rosters
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.*
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.DetailVenueCardImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.GenericImageLoader
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.PressIconButton
import com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables.VideoPlayer
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIRST_TEAM
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SECOND_TEAM
import com.sgut.android.nationalfootballleague.utils.formatTo
import com.sgut.android.nationalfootballleague.utils.toDate
import kotlin.math.nextUp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsScreen(
    modifier: Modifier = Modifier,
    sport: String,
    league: String,
    navController: NavController,
    event: String,
    gameDetailViewModel: GameDetailViewModel = hiltViewModel(),
) {

    gameDetailViewModel.loadGameDetails(sport, league, event)

//    val playerMap by gameDetailViewModel.getRosterMap()

    val gameDetailUiState by gameDetailViewModel.gameDetailUiState.collectAsState()
    Log.d("GAMEDETAIL-UISTATE", gameDetailUiState.currentGameUiState.toString())

//    val map by remember {gameDetailViewModel.teamMap}


    Scaffold(
        content = { padding ->
            Column(
                modifier
                    .verticalScroll(rememberScrollState())
                    .padding(8.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

//                messing around with
//                Text(text = gameDetailUiState.currentGameUiState?.rosters?.last()?.roster.toString())

//                Card(modifier = Modifier.fillMaxWidth()) {
//
//                    //size of map
//                    Text(text = gameDetailViewModel.teamMap.size.toString())

//                    Text(text = gameDetailViewModel.getPlayerFromId(gameDetailUiState.currentGameUiState?.baseballSituation?.batter?.playerId.toString()).shortName)
//                    GenericImageLoader(obj = gameDetailViewModel.getPlayerFromId(gameDetailUiState.currentGameUiState?.baseballSituation?.batter?.playerId.toString()).headshot?.href
//                        ?: "", modifier = Modifier.size(80.dp))
//
//                    Text(text = gameDetailViewModel.getPlayerFromId(gameDetailUiState.currentGameUiState?.baseballSituation?.pitcher?.playerId.toString()).shortName)
//                    GenericImageLoader(obj = gameDetailViewModel.getPlayerFromId(gameDetailUiState.currentGameUiState?.baseballSituation?.pitcher?.playerId.toString()).headshot?.href
//                        ?: "", modifier = Modifier.size(80.dp))
//
//                }


                CompetitionStatus(competitions = gameDetailUiState.currentGameUiState?.header?.competitions
                    ?: listOf())

                HeaderStatusSlot(
                    gameDetailModel = gameDetailUiState.currentGameUiState ?: GameDetailsModel())


                Spacer(modifier = modifier.height(8.dp))

                Probables(list = gameDetailUiState.currentGameUiState?.header?.competitions?.first()?.probables
                    ?: listOf())


                WeightedRows(header = gameDetailUiState.currentGameUiState ?: GameDetailsModel())



                when (gameDetailUiState.currentSport) {
                    "basketball" -> DoughnutChartForBasketball(
                        gameDetailModel = gameDetailUiState.currentGameUiState
                            ?: GameDetailsModel(),
                    )
                    "football" -> DoughnutChart2(
                        gameDetailModel = gameDetailUiState.currentGameUiState
                            ?: GameDetailsModel(),
                    )
                    "baseball" -> BaseballSpecific(
                        gameDetailSituation = gameDetailUiState.currentGameUiState?.baseballSituation
                            ?: SituationModel(),
                        gameDetailsModel = gameDetailUiState.currentGameUiState
                            ?: GameDetailsModel(),
                        teamMap = gameDetailViewModel.teamMap
                    )
                }


                SeasonLeaders(
                    gameDetailModel = gameDetailUiState.currentGameUiState ?: GameDetailsModel()
                )


                NewVidList(
                    vidList = gameDetailUiState.currentGameUiState?.videos ?: listOf()
                )


                TabsLastFiveGames(
                    lastFiveGames = gameDetailUiState.currentGameUiState?.lastFiveGames ?: listOf()
                )


                ExpandableGameArticle(
                    gameDetailModel = gameDetailUiState.currentGameUiState ?: GameDetailsModel(),
                    gameDetailViewModel
                )

                FindTickets(
                    ticketsInfo = gameDetailUiState.currentGameUiState?.ticketsInfo
                        ?: TicketsInfoModel()
                )

                InjuriesReportCard(gameDetailModel = gameDetailUiState.currentGameUiState
                    ?: GameDetailsModel())


                GameInformation(
                    gameDetailModel = gameDetailUiState.currentGameUiState ?: GameDetailsModel(),
                )

                TeamStatCard3(boxscore = gameDetailUiState.currentGameUiState?.boxscore
                    ?: BoxScoreModel())


            }

        }
    )
}


@Composable
fun EnhancedBaseballSituation() {

}


@Composable
fun BaseballSpecific(
    gameDetailSituation: SituationModel,
    gameDetailsModel: GameDetailsModel,
    teamMap: Map<String, GameDetailsAthleteDetailsModel>,
) {
    BaseballSituation(
        gameDetailSituation = gameDetailSituation,
        teamMap = teamMap,
        competition = gameDetailsModel.header?.competitions?.first()
            ?: GameDetailsCompetitionModel()
    )

    DoughnutChart2(
        gameDetailModel = gameDetailsModel
    )


}

//@Composable
//fun DueUp() {
//    gameDetailUiState.currentGameUiState?.baseballSituation?.dueUp?.map { Text(text = it.playerId) }
//
//}

@Composable
fun RosterItem(rosterPerson: RosterModel) {
    Card() {
        Column() {
            Row() {
                GenericImageLoader(
                    obj = rosterPerson.athlete.headshot?.href ?: "",
                    modifier = Modifier.size(60.dp)
                )
                Text(text = "Name: $rosterPerson.athlete.displayName, ${rosterPerson.position.displayName}")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Bat order: $rosterPerson.batOrder.toString()")
            }
        }
    }
}


@Composable
fun CompetitionStatus(competitions: List<GameDetailsCompetitionModel>) {
    Card(modifier = Modifier.fillMaxWidth()) {
        competitions.map { status ->
            Text(text = status.status?.type?.shortGameTimeDetail ?: "")
        }
    }
}

// use for home and away
@Composable
fun LineUp(lineUp: List<RostersModel>) {

    lineUp.map { roster ->
        roster.roster.map { RosterItem(rosterPerson = it) }
    }
}


@Composable
fun BoxScore(boxscore: GameDetailsBoxscore) {
    boxscore.teams.map { team ->
        Text(text = team.team?.name ?: "")
        team.statistics.map { stats ->
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = stats.displayValue ?: "")

                }
            }
        }
    }
}

@Composable
fun BoxScore2(boxscore: GameDetailsBoxscore) {
    Column() {
        Row() {
            boxscore.teams.map { team ->
                Text(text = team.team?.name ?: "")
            }
        }
        boxscore.teams.map { team ->
            team.statistics.map { stats ->
                Text(text = stats.displayValue ?: "")
            }
        }

    }
    boxscore.teams.map { team ->
        Text(text = team.team?.name ?: "")
        team.statistics.map { stats ->
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = stats.displayValue ?: "")

                }
            }
        }
    }
}


@Composable
fun ExpandableGameArticle(
    gameDetailModel: GameDetailsModel,
    //take gamedeetail viewmodel out of here
    gameDetailViewModel: GameDetailViewModel,
) {
    var showMore by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier
            .animateContentSize(animationSpec = tween(100))
            .fillMaxWidth()
            .padding(4.dp)

            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { showMore = !showMore }) {


            if (gameDetailModel.singleGameArticle?.story?.isEmpty() == true) {
                Text(text = "")
            } else {
                if (showMore) {
                    HtmlText(html = gameDetailModel.singleGameArticle?.story ?: "")
                } else {
                    Text(
                        text = gameDetailModel.singleGameArticle?.headline ?: "",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )


                    HtmlText(html = gameDetailModel.singleGameArticle?.description ?: "")
                    Row() {
                        Text(text = gameDetailModel.singleGameArticle?.published ?: "")

                        Text(text = " - ")
                        Text(text = gameDetailModel.singleGameArticle?.source ?: "")
                    }
                }
            }


            var isPressed by remember { mutableStateOf(false) }
            val context = LocalContext.current
            PressIconButton(
                onClick = {
//                    TODO fix removing viewmodel pass onClick
//                    gameDetailViewModel.onSaveArticleClick(gameDetailModel)
                    Toast.makeText(context, "Saved to list", Toast.LENGTH_SHORT).show()

                    Toast.makeText(context, "Added to articles for later", Toast.LENGTH_SHORT)
                        .show()
                    when (isPressed) {
                        true -> isPressed = false
                        false -> isPressed = true
                    }
                },
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                text = { Text(if (isPressed) "Saved" else "Save for later") },
                isPressed = isPressed
            )


        }
    }
}

@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_OPTION_USE_CSS_COLORS) }
    )
}

@Composable
fun WeightedRows(header: GameDetailsModel) {
    Card(modifier = Modifier.fillMaxWidth()

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                header.header?.competitions?.map { competitions ->
                    Text(text = competitions.status?.type?.description ?: "")

                    competitions.competitors.map { competitors ->
                        competitors.team?.record?.map { teamRecord ->
                            Column() {
                                Text(text = teamRecord.type)
                                Text(text = teamRecord.displayValue)
                                Text(text = teamRecord.summary)
                            }
                        }
                        Box() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = competitors.team?.abbreviation ?: "",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                GenericImageLoader(
                                    obj = competitors.team?.logos?.href ?: "",
                                    modifier = Modifier.width(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LongGameTimeDetail(gameDetailModel: GameDetailsModel) {
    Text(text = gameDetailModel.header?.competitions?.getOrNull(0)?.status?.type?.gameTimeDetail
        ?: "", fontSize = 11.sp)

}

@Composable
fun ScoringPlay(scoringPlays: ScoringPlays) {
    Column() {
        Text(text = scoringPlays.team?.name ?: "")
        Text(text = scoringPlays.type?.text ?: "")
        Text(text = "Period: " + scoringPlays.period?.number.toString())

    }
}


@Composable
fun WinProbabilityGraph(winProbability: List<WinprobabilityModel>) {

    winProbability
//        .sortedBy { it.homeWinPercentage }
        .map { Text(text = it.homeWinPercentage.nextUp().toString()) }
}

@Composable
fun HeaderTeamLogo(team: GameDetailsTeamInfoModel) {
    GenericImageLoader(
        obj = team.logos.href,
        modifier = Modifier.size(60.dp))
}

@Composable
fun HeaderTeamItem(competitors: GameDetailsCompetitorModel) {
    Column() {
        Row() {
            competitors.team?.name
            competitors.team?.abbreviation
            HeaderTeamLogo(competitors.team ?: GameDetailsTeamInfoModel())
        }
    }

}


@Composable
fun HeaderTeamSlot(competitors: GameDetailsCompetitorModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = competitors.team?.abbreviation ?: "", fontSize = 12.sp)
            Text(text = competitors.record.getOrNull(0)?.summary ?: "", fontSize = 9.sp)
        }

        HeaderTeamItem(competitors)
    }
}


@Composable
fun GameArticle(gameDetailModel: GameDetailModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)) {
            Text(
                text = gameDetailModel.singleArticle?.headline ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = gameDetailModel.singleArticle?.description ?: "",
                fontSize = 14.sp
            )

            Row() {

//                Text(text = gameDetailModel.singleArticle?.story ?: "") for expand anim
                Text(text = gameDetailModel.singleArticle?.published ?: "")
                Text(text = " - ")
                Text(text = gameDetailModel.singleArticle?.source ?: "")
            }
        }
    }
}

@Composable
fun SeasonLeaders(gameDetailModel: GameDetailsModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = "Season Leaders",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold
        )

        Divider()
        Row(

        ) {
            gameDetailModel.leaders.map { gameDetailsLeaders ->
                Row() {

                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            GenericImageLoader(
                                obj = gameDetailsLeaders.team.logo,
                                modifier = Modifier.size(50.dp)
                            )
                            Text(text = gameDetailsLeaders.team.abbreviation,
                                fontWeight = FontWeight.Bold)
                        }

                        gameDetailsLeaders.leaders.map { gameDetailsLeaders2 ->
                            Text(text = gameDetailsLeaders2.displayName,
                                fontWeight = FontWeight.Bold)
                            Column() {
                                Row() {
                                    gameDetailsLeaders2.leadersAthlete.map { leaderAthlete ->
                                        SeasonLeadersPlayer(athlete = leaderAthlete)

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SeasonLeaderPlayerItem(athlete: AthleteLeaders) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        GenericImageLoader(
            obj = athlete.athlete.headshot?.href ?: "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)

                .border(width = 1.dp, color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = athlete.athlete.shortName ?: "")
            Text(text = athlete.displayValue)


        }

    }
}

@Composable
fun NewVidList(vidList: List<VideoModel>) {
    Column() {
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Videos")
        LazyRow(contentPadding = PaddingValues(8.dp)) {
            items(items = vidList) { vid ->
                VideoPreview(video = vid, modifier = Modifier.padding(8.dp))

            }
        }
    }
}


@Composable
fun VideoPreview(
    video: VideoModel,
    modifier: Modifier,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {

                VideoPlayer(video)
                Log.d("Video", video.links.source?.mezzanine?.href ?: "")

                GenericImageLoader(
                    obj = video.thumbnail,
                    modifier = Modifier.width(200.dp)
                )

                Text(
                    text = video.headline,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Left,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun DisplayLabels(list: List<GameDetailsStatisticModel>) {
    Column() {
        list.map {
            Text(text = it.label, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            Text(text = it.displayValue, fontSize = 10.sp)
        }

    }

}

@Composable
fun TeamStatCard2(boxscore: BoxScoreModel) {
    Card(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Team Stats", fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold
        )
        Column(verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                horizontalArrangement = Arrangement.End
            ) {
                boxscore.teams.map {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(text = it.team?.abbreviation ?: "",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column() {
                                DisplayLabels(list = it.statistics)
                            }
                        }
                    }

                }
            }


        }
    }
}

@Composable
fun TeamStatCard3(boxscore: BoxScoreModel) {

    Card(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Team Stats", fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                boxscore.teams.map {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(text = it.team?.abbreviation ?: "",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column() {
                                DisplayLabels(list = it.statistics)
                            }
                        }
                    }

                }
            }


        }
    }
}

@Composable
fun TeamStat(boxscore: BoxScoreModel) {
    Card(modifier = Modifier.fillMaxWidth()) {

        boxscore.teams.map {
            Row() {
                Column() {
                    Text(text = it.team?.name ?: "")
                    DisplayLabels(list = it.statistics)
                }
            }
        }

        Column(verticalArrangement = Arrangement.Center) {
            Row() {
                boxscore.teams.map {
                    Row() {
                        Text(text = it.team?.displayName ?: "")
                        Column() {
                            DisplayLabels(list = it.statistics)
                        }
                    }
                }
            }


        }
    }
}

@Composable
fun SeasonLeadersPlayer(athlete: AthleteLeaderModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,

        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)

    ) {
        Column() {
            Text(
                text = athlete.athlete.shortName,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = athlete.displayValue,
                fontSize = 9.sp,
                color = Color.Gray,
                lineHeight = 10.sp,
                maxLines = 2,
                overflow = TextOverflow.Visible,
                modifier = Modifier.width(90.dp)
            )
        }
        Column() {
            GenericImageLoader(
                obj = athlete.athlete.headshot?.href ?: "",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .align(Alignment.End)

            )
        }
    }
}

@Composable
fun RightToLeftLayout(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        content()
    }
}

@Composable
fun Probables(list: List<ProbablesModel>) {
    Card() {
        list.map { prob ->
            Text(text = prob.displayName)
            Text(text = prob.athlete?.displayName ?: "")
        }
    }
}

@Composable
fun HeaderStatusSlot(gameDetailModel: GameDetailsModel) {
    Card(
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {


                gameDetailModel.header?.competitions!!.map { competition ->
                    HeaderTeamSlot(competitors = competition.competitors.get(FIRST_TEAM))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        gameDetailModel.header.competitions.map {
                            Text(
                                text = it.date.toDate()?.formatTo("MMM/dd") ?: "",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }


                        gameDetailModel.header.competitions.map { competition ->
                            Text(
                                text = competition.status?.type?.description ?: "",
                                fontSize = 12.sp
                            )

                            Text(
                                text = competition.date.toDate()?.formatTo("K:mm aa") ?: "",
                                fontSize = 9.sp
                            )

                        }

                    }

                    RightToLeftLayout {
                        HeaderTeamSlot(competitors = competition.competitors.get(SECOND_TEAM))

                    }
                }
            }

        }
    }
}


@Composable
//multiple same name fields only last one will be used
fun InjuriesReportCard(
    gameDetailModel: GameDetailsModel,
) {
    val team1Display = gameDetailModel.injuries.getOrNull(0)?.team?.displayName
    val team2Display = gameDetailModel.injuries.getOrNull(1)?.team?.displayName
    val injuries1 = gameDetailModel.injuries.getOrNull(0)
    val injuries2 = gameDetailModel.injuries.getOrNull(1)
    val team1Logo = gameDetailModel.injuries.getOrNull(0)?.team
    val team2Logo = gameDetailModel.injuries.getOrNull(1)?.team

    if (injuries1?.injuries?.isEmpty() == true) {
        Text(text = "")
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Injury Report",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )

            Divider()

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (team1Logo != null) {
                    GenericImageLoader(obj = team1Logo.logo, modifier = Modifier.size(35.dp))
                }
                Text(text = team1Display ?: "", fontWeight = FontWeight.Bold)


            }

            if (injuries1 != null) {
                InjuryColumn(injuries = injuries1)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (team2Logo != null) {
                    GenericImageLoader(obj = team2Logo.logo, modifier = Modifier.size(35.dp))
                }
                Text(text = team2Display ?: "", fontWeight = FontWeight.Bold)
            }
            if (injuries2 != null) {
                InjuryColumn(injuries = injuries2)
            }
        }
    }


}

@Composable
fun InjuryColumn(injuries: GameDetailsInjuriesListModel) {
    Column() {
        Row() {
        }
        injuries.injuries.map {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AthleteNameAndPosition(athlete = it.athlete)


                Text(text = it.status, textAlign = TextAlign.Right)

            }
        }
    }

}

@Composable
fun AthleteNameAndPosition(athlete: GameDetailsAthleteDetailsModel) {
    Row() {
        Text(text = athlete.displayName)
        Text(text = " ")
        Text(text = athlete.position?.abbreviation ?: "", color = Color.Blue)
    }
}

@Composable
fun BaseBallRosterLineUp(rosters: List<Rosters>) {
    Card() {
//        Text(text = rosters.map { it.team?.abbreviation. })

    }
}

@Composable
fun BaseballSituation(
    gameDetailSituation: SituationModel,
    competition: GameDetailsCompetitionModel,
    teamMap: Map<String, GameDetailsAthleteDetailsModel>,
//    onPlayerId: (str: String) -> String
) {

//    TOP/MIDDLE/BOTTOM/END are Competition status types
    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            InningText(competition = competition)
            Divider()
            OutsBallsStrikes(gameDetailSituation = gameDetailSituation)
            Divider()

            if (competition.status?.periodPrefix.equals("End")){

                gameDetailSituation.dueUp.map { dueUp ->
                    Player(player = teamMap[dueUp.playerId.toString()] ?: GameDetailsAthleteDetailsModel())
                }
                gameDetailSituation.dueUp.map { dueUp ->
                    DueUpItem(dueUpItemModel = dueUp)
                }
            } else {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Player(player = teamMap[gameDetailSituation.batter?.playerId.toString()]
                        ?: GameDetailsAthleteDetailsModel())

                    Text(text = "Vs")

                    Player(player = teamMap[gameDetailSituation.pitcher?.playerId.toString()]
                        ?: GameDetailsAthleteDetailsModel())

                }
            }

//            Text(text = gameDetailSituation.toString())
            Divider()

            Text(text = "On First")
            Row() {
                Player(player = teamMap[gameDetailSituation.onFirst.toString()] ?: GameDetailsAthleteDetailsModel())
            }
            Text(text = "On Second")
            Row() {
                Player(player = teamMap[gameDetailSituation.onSecond.toString()] ?: GameDetailsAthleteDetailsModel())
            }
            Text(text = "On Third")
            Row() {
                Player(player = teamMap[gameDetailSituation.onThird.toString()] ?: GameDetailsAthleteDetailsModel())
            }
        }
    }

}

@Composable
fun DueUpItem(dueUpItemModel: DueUpItemModel) {
    Text(text = "${dueUpItemModel.playerId}, ${dueUpItemModel.batOrder.toString()}  ")
}



@Composable
fun Player(player: GameDetailsAthleteDetailsModel) {
    Box(modifier = Modifier.wrapContentSize()) {
        Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = player.shortName, fontWeight = FontWeight.Bold)

            GenericImageLoader(obj = player.headshot?.href ?: "", modifier = Modifier.size(60.dp))
            Text(text = player.position?.displayName ?: "non")

        }
    }
}

@Composable
fun PitcherVsBatter(gameDetailSituation: SituationModel) {

}

@Composable
fun OutsBallsStrikes(
    gameDetailSituation: SituationModel,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Outs " + gameDetailSituation.outs.toString())
        Text(text = "Balls " + gameDetailSituation.balls.toString())
        Text(text = "Strikes " + gameDetailSituation.strikes.toString())
    }
}

@Composable
fun InningText(competition: GameDetailsCompetitionModel) {

    Text(text = competition.status?.type?.gameTimeDetail ?: "", style = MaterialTheme.typography.displayMedium)
    Divider()
    Text(text = competition.status?.periodPrefix ?: "")

}

@Composable
fun DoughnutChart2(
    gameDetailModel: GameDetailsModel,
    size: Dp = 200.dp,
    thickness: Dp = 20.dp,
) {
    val colors = mutableListOf<Color>()
    val legends = mutableListOf<String>()
    val teams = gameDetailModel.boxscore?.teams


    teams?.map {
        colors.add(HexToJetpackColor2.getColor(it.team?.color ?: ""))
        legends.add(it.team?.name ?: "")
    }

    colors.reverse()
    legends.reverse()

    colors.add(Color.LightGray)
    legends.add("Tie")

//for nba only response is "AWAYTEAM"

    val gameProjection = gameDetailModel.predictor?.homeTeam?.gameProjection ?: 0f
    val teamChanceLoss = gameDetailModel.predictor?.homeTeam?.teamChanceLoss ?: 0f
    val teamChanceTie = gameDetailModel.predictor?.homeTeam?.teamChanceTie ?: 0f
    val values = listOf(gameProjection, teamChanceLoss, teamChanceTie)

    val sumOfValues = values.sum()
    val proportions = values.map { it * 100 / sumOfValues }
    val sweepAngles = proportions.map { it * 360 / 100 }


    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Matchup Predictor", fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold)
            }
            Divider()
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "$gameProjection%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                )
                Text(
                    text = "$teamChanceLoss%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                )

                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = teams?.get(0)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .height(100.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = teams?.get(1)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Canvas(
                    modifier = Modifier
                        .size(size = size)
                        .padding(16.dp)
                        .align(Alignment.Center),
                ) {

                    var startAngle = -90f
                    for (i in values.indices) {

                        drawArc(
                            color = colors.getOrElse(i) { color -> Color.White },
                            startAngle = startAngle,
                            sweepAngle = sweepAngles[i],
                            useCenter = false,
                            style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt)
                        )
                        startAngle += sweepAngles[i]
                    }
                }
            } //end of box

            Spacer(modifier = Modifier.height(8.dp))

            Column() {

                Text(
                    text = "Tie: $teamChanceTie%",
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
                for (i in values.indices) {
                    DisplayLegend(
                        color = colors.getOrElse(i, { color -> Color.White }),
                        legend = legends.getOrElse(i, { word -> "" }))
                }
            }
        }
    }
}


@Composable
fun DisplayLegend(color: Color, legend: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = legend, color = Color.Blue, fontSize = 12.sp)

    }

}

@Composable
fun DoughnutChartForBasketball(
    gameDetailModel: GameDetailsModel,
    size: Dp = 200.dp,
    thickness: Dp = 20.dp,
) {
    val colors = mutableListOf<Color>()
    val legends = mutableListOf<String>()
    val teams = gameDetailModel.boxscore?.teams

    teams?.map {
        colors.add(HexToJetpackColor2.getColor(it.team?.color ?: ""))
        legends.add(it.team?.name ?: "")
    }


    colors.add(Color.LightGray)
    legends.add("Tie")

//for nba only response is "AWAYTEAM"

    val gameProjection = gameDetailModel.predictor?.awayTeam?.gameProjection ?: 0f
    val teamChanceLoss = gameDetailModel.predictor?.awayTeam?.teamChanceLoss ?: 0f
    val teamChanceTie = gameDetailModel.predictor?.awayTeam?.teamChanceTie ?: 0f
    val values = listOf(gameProjection, teamChanceLoss, teamChanceTie)

    val sumOfValues = values.sum()
    val proportions = values.map { it * 100 / sumOfValues }
    val sweepAngles = proportions.map { it * 360 / 100 }


    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Matchup Predictor", fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold)
            }
            Divider()
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "$gameProjection%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                )
                Text(
                    text = "$teamChanceLoss%",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                )
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .align(Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = teams?.get(1)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .height(100.dp)
                                .width(1.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = teams?.get(0)?.team?.abbreviation ?: "",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Canvas(
                    modifier = Modifier
                        .size(size = size)
                        .padding(16.dp)
                        .align(Alignment.Center),
                ) {
                    var startAngle = -90f
                    for (i in values.indices) {
                        drawArc(
                            color = colors.getOrElse(i) { color -> Color.White },
                            startAngle = startAngle,
                            sweepAngle = sweepAngles[i],
                            useCenter = false,
                            style = Stroke(width = thickness.toPx(), cap = StrokeCap.Butt),
                        )
                        startAngle += sweepAngles[i]
                    }

                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column() {
                Text(text = "Win Prediction", textAlign = TextAlign.Center)
                for (i in values.indices) {
                    DisplayLegend(
                        color = colors.getOrElse(i, { color -> Color.White }),
                        legend = legends.getOrElse(i, { word -> "" }))
                }
            }
        }
    }
}


@Composable
fun DisplayLegend2(color: Color, legend: String, value: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = legend, color = Color.Blue, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(4.dp))

        Text(text = value.toString(), color = Color.Blue, fontSize = 16.sp)

    }

}


@Composable
fun PickCenter(
    pickCenterInfo: PickcenterModel,
) {
    Card() {
        Text(text = pickCenterInfo.provider.name)
    }
}

@Composable
fun TeamStatsCard() {

}

@Composable
fun GameInformation(
    gameDetailModel: GameDetailsModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text(
                text = "Game Information",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Divider()

        GameInfoCardVenueImage(gameDetailModel = gameDetailModel, modifier = Modifier)

        Row() {
            Text(text = "Coverage: ", fontSize = 12.sp)
            Text(text = gameDetailModel.broadcasts.getOrNull(0)?.station
//                ?: gameDetailModel.header?.competitions?.getOrNull(0)?.broadcasts?.getOrNull(1)?.media?.shortName
                ?: "", fontSize = 12.sp, fontWeight = FontWeight.Bold)

        }
        LongGameTimeDetail(gameDetailModel = gameDetailModel)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)


        ) {
            Text(text = gameDetailModel.gameInfo?.weather?.temperature ?: "TEMP")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AddressComp(gameDetailModel = gameDetailModel)
            Text(text = gameDetailModel.gameInfo?.weather?.temperature ?: "",
                fontWeight = FontWeight.Bold)
        }
        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "CAPACITY: ", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = gameDetailModel.gameInfo?.venue?.capacity.toString(), fontSize = 12.sp)
        }
    }
}

@Composable
fun AddressComp(gameDetailModel: GameDetailsModel) {
    Row() {
        Text(text = gameDetailModel.gameInfo?.venue?.address?.city ?: "")
        Text(text = ", ")
        Text(text = gameDetailModel.gameInfo?.venue?.address?.state ?: "")
    }
}


@Composable
fun TeamVsComponent() {

}


fun getTeamsColorsList(gameDetailModel: GameDetailModel): List<Color?> {
    var list = listOf<Color?>()
    for (i in gameDetailModel.boxscore?.teams!!) {
        list = listOf(HexToJetpackColor2.getColor(i.team?.color ?: "")

        )
    }
    return list
}


@Composable
fun FindTickets(ticketsInfo: TicketsInfoModel) {
    val team1 = ticketsInfo.seatSituation?.opponentTeamName
    val team2 = ticketsInfo.seatSituation?.currentTeamName
    val venueName = ticketsInfo.seatSituation?.venueName
    val shortDate = ticketsInfo.seatSituation?.dateShort
    val dateDay = ticketsInfo.seatSituation?.dateDay
    val dropDownOptions = ticketsInfo.tickets

    if (ticketsInfo.tickets.isEmpty()) {
        Text(text = "")
    } else {

        Card(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Find Tickets",
                    textAlign = TextAlign.Start,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Divider()
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "$team1 vs $team2",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "$venueName - $dateDay $shortDate",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = ticketsInfo.seatSituation?.summary ?: "",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue
                )
            }
            Divider()
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Buy $team2 tickets with VividSeats",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue
                )
            }
            Divider()

            // dropdowm
            DropDownFun(dropDownOptions)

        }

    }


}

@Composable
fun DropDownFun(tickets: List<TicketModel>) {
    val listItems = tickets
    val disabledItem = 1
    val toastConext = LocalContext.current.applicationContext
    var expanded by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.Center) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = ""
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            listItems.forEachIndexed { itemIndex, itemValue ->
                DropDownMenuItem(
                    onClick = {
                        expanded = false
                    },
                    enabled = (itemIndex != disabledItem)
                ) {
                    Text(text = itemValue.ticketName.toString())
                }
            }

        }
    }
}


@Composable
fun DropDownMenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {

}


@Composable
fun TabsLastFiveGames(lastFiveGames: List<LastFiveGamesModel>) {

    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf(lastFiveGames.getOrNull(0)?.team,
        lastFiveGames.getOrNull(1)?.team)

    Card() {
        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex) {
                tabTitles.forEachIndexed { index, team ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Box() {
                                Row(horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    GenericImageLoader(obj = team?.logo.toString(),
                                        modifier = Modifier.size(30.dp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = team?.abbreviation ?: "")

                                }
                            }

                        },
                    )
                }
            }
            when (tabIndex) {
                0 -> LastFiveGames2(lastFiveGames = lastFiveGames, 0)
                1 -> LastFiveGames2(lastFiveGames = lastFiveGames, 1)

            }
        }
    }
}


@Composable
fun LastFiveGameRow(lastEvents: GameDetailsEventModel) {
    Row(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = lastEvents.gameDate.toDate()?.formatTo("MM-dd-yyyy") ?: "", fontSize = 10.sp)
        Spacer(modifier = Modifier.width(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = lastEvents.atVs,
                fontSize = 16.sp
            )
            GenericImageLoader(obj = lastEvents.opponent.logo, modifier = Modifier.size(30.dp))
            Text(
                text = lastEvents.opponent.abbreviation,
                fontSize = 12.sp,
                textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = lastEvents.gameResult, fontSize = 12.sp, textAlign = TextAlign.Start)
            Text(text = lastEvents.score, fontSize = 12.sp, textAlign = TextAlign.Start)
        }
    }
}


@Composable
fun LastFiveGames2(
    lastFiveGames: List<LastFiveGamesModel>,
    teamInt: Int,
) {
    val team1Info = lastFiveGames.getOrNull(teamInt)
    val team2Info = lastFiveGames.getOrNull(1)

    if (lastFiveGames.isEmpty()) {
        Text(text = "")
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(text = "Last Five Games",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "DATE")
                Text(text = "OPP")
                Text(text = "RESULT")
            }
            team1Info?.lastEvents?.map { LastFiveGameRow(lastEvents = it) }
        }
    }


}

@Composable
fun GameInfoCardVenueImage(
    gameDetailModel: GameDetailsModel,
    modifier: Modifier,
) {
    Box(modifier = Modifier.height(200.dp)) {
        DetailVenueCardImageLoader(venue = gameDetailModel.gameInfo?.venue
            ?: GameDetailsVenueModel())

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Row() {
                val offset = Offset(5.0f, 5.0f)
                Text(
                    text = gameDetailModel.gameInfo?.venue?.fullName ?: "",
                    style = TextStyle(
                        fontSize = 50.sp,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = offset,
                            blurRadius = 3f
                        )
                    ),
                    textAlign = TextAlign.Right,
                    color = Color.White
                )
            }

        }
    }
}






