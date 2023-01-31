package com.sgut.android.nationalfootballleague.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sgut.android.nationalfootballleague.data.db.ArticleDao
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.dtomappers.*
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.LogService
import com.sgut.android.nationalfootballleague.data.service.StorageService
import com.sgut.android.nationalfootballleague.data.service.impl.AccountServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.LogServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.StorageServiceImpl
import com.sgut.android.nationalfootballleague.data.repository.EspnRepository
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    @Singleton
    fun provideSportsDatabase(@ApplicationContext context: Context): SportsDataBase =
        Room.databaseBuilder(
            context,
            SportsDataBase::class.java,
            "sports_db"
        ).build()

    @Provides
    fun provideEspnRepository(
        espnApi: EspnApi,
        articleMapper: NetworkToDomainArticleMapper,
        nflMapper: NetworkToTeamDomainModelMapper,
        teamDetailNetworkToModelMapper: TeamDetailNetworkToModelMapper,
        rosterMapper: TeamDetailWithRosterMapper,
        scoreboardMapper: NetworkScoreboardToDomainModelMapper,
        gameDetailsToDomainModelMapper: NetworkGameDetailsToDomainModelMapper,
        sportsDataBase: SportsDataBase
    ): EspnRepository = EspnRepository(nflMapper, espnApi, sportsDataBase, articleMapper, teamDetailNetworkToModelMapper, rosterMapper, scoreboardMapper, gameDetailsToDomainModelMapper)


    @Provides
    fun provideNetworkGameDetailsToDomainModelMapper():  NetworkGameDetailsToDomainModelMapper = NetworkGameDetailsToDomainModelMapper()


    @Provides
    fun provideNetworkToTeamDomMapper():  NetworkToTeamDomainModelMapper = NetworkToTeamDomainModelMapper()

    @Provides
    fun provideNetworkToDomainArticleMapper(): NetworkToDomainArticleMapper = NetworkToDomainArticleMapper()

    @Provides
    fun provideRosterMapper(): TeamDetailWithRosterMapper = TeamDetailWithRosterMapper()

    @Provides
    fun provideScoreboardMapper(): NetworkScoreboardToDomainModelMapper = NetworkScoreboardToDomainModelMapper()

    @Provides
    fun provideNetworkToTeamDetailMapper():  TeamDetailNetworkToModelMapper = TeamDetailNetworkToModelMapper()

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideEspnApi(okHttpClient: OkHttpClient): EspnApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EspnApi::class.java)


    //Firebase things
    @Provides
    fun auth(): FirebaseAuth = Firebase.auth

    @Provides
    fun firestore(): FirebaseFirestore = Firebase.firestore

    // services things

    @Module
    @InstallIn(ViewModelComponent::class)
    abstract class ServiceModule {
        @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService

        @Binds abstract fun provideLogService(impl: LogServiceImpl): LogService

        @Binds abstract fun provideStorageService(impl: StorageServiceImpl): StorageService


    }




}