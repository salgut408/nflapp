package com.sgut.android.nationalfootballleague.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.db.article.ArticleDao
import com.sgut.android.nationalfootballleague.data.db.team.TeamsDao
import com.sgut.android.nationalfootballleague.data.location.DefaultLocationTrackerImpl
import com.sgut.android.nationalfootballleague.data.remote.api.SportsApi
import com.sgut.android.nationalfootballleague.data.repository.*
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.LogService
import com.sgut.android.nationalfootballleague.data.service.StorageService
import com.sgut.android.nationalfootballleague.data.service.impl.AccountServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.LogServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.StorageServiceImpl
import com.sgut.android.nationalfootballleague.domain.location.LocationTracker
import com.sgut.android.nationalfootballleague.domain.repositories.*
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetBaseballSituationUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.GetScoresUseCase
import com.sgut.android.nationalfootballleague.domain.use_cases.PlayersMapUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideArticleDao(sportsDataBase: SportsDataBase): ArticleDao = sportsDataBase.getArticleDao()

    @Provides
    fun provideTeamDao(sportsDataBase: SportsDataBase): TeamsDao = sportsDataBase.getTeamsDao()



    @Provides
    @Singleton
    fun provideSportsDatabase(@ApplicationContext context: Context): SportsDataBase =
        Room.databaseBuilder(
            context,
            SportsDataBase::class.java,
            "sports_db"
        ).fallbackToDestructiveMigration()
            .build()
    

    @Provides
     fun provideTeamsListRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase,

    ): TeamsListsRepository = TeamsListRepositoryImpl(sportsApi, sportsDataBase, )

    //Location

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(application)

    @Provides
    @Singleton
    fun providesLocationTracker(
        fusedLocationProviderClient: FusedLocationProviderClient,
        application: Application
    ): LocationTracker = DefaultLocationTrackerImpl(
        fusedLocationProviderClient = fusedLocationProviderClient,
        application = application
    )

    @Provides
    fun provideStandingsRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase,
    ): StandingsRepository = StandingsRepositoryImpl(sportsApi, sportsDataBase)


    @Provides
    fun provideTeamsDetailRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase
    ): TeamDetailsRepository = TeamDetailsRepositoryImpl(sportsApi, sportsDataBase)

    @Provides
    fun provideGameDetailsRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase
    ): GameDetailsRepository = GameDetailsRepositoryImpl(sportsApi, sportsDataBase)


    @Provides
    fun provideScoreboardRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase
    ): ScoreboardRepository = ScoreboardRepositoryImpl(sportsApi, sportsDataBase)

    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideArticleRepository(
        sportsApi: SportsApi,
        sportsDataBase: SportsDataBase,
        ioDispatcher: CoroutineDispatcher
    ): ArticleRepository = ArticleRepositoryImpl(sportsApi, sportsDataBase, ioDispatcher)


    @Provides
    fun provideArticleUseCase(
        articleRepository: ArticleRepository,
    ): GetArticlesUseCase = GetArticlesUseCase(articleRepository)

    @Provides
    fun provideGetBaseballSituationUseCase(
        gameDetailsRepository: GameDetailsRepository,
    ): GetBaseballSituationUseCase = GetBaseballSituationUseCase(gameDetailsRepository)

    @Provides
    fun providePlayersMapUseCase(
        teamDetailsRepository: TeamDetailsRepository
    ): PlayersMapUseCase = PlayersMapUseCase(teamDetailsRepository )

    @Provides
    fun provideGetScoresUseCase (
        scoreboardRepository: ScoreboardRepository
    ): GetScoresUseCase = GetScoresUseCase(scoreboardRepository)

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideEspnApi(okHttpClient: OkHttpClient): SportsApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SportsApi::class.java)


    //Firebase things
    @Provides
    fun auth(): FirebaseAuth = Firebase.auth

    @Provides
    fun firestore(): FirebaseFirestore = Firebase.firestore

    @Module
    @InstallIn(ViewModelComponent::class)
    abstract class ServiceModule {
        @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService

        @Binds abstract fun provideLogService(impl: LogServiceImpl): LogService

        @Binds abstract fun provideStorageService(impl: StorageServiceImpl): StorageService


    }




}