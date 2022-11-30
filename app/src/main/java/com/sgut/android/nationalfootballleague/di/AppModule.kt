package com.sgut.android.nationalfootballleague.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkScoreboardToDomainModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.TeamDetailNetworkToModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.TeamDetailWithRosterMapper
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
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideEspnRepository(
        espnApi: EspnApi,
        nflMapper: NetworkToTeamDomainModelMapper,
        teamDetailNetworkToModelMapper: TeamDetailNetworkToModelMapper,
        rosterMapper: TeamDetailWithRosterMapper,
        scoreboardMapper: NetworkScoreboardToDomainModelMapper,
    ): EspnRepository = EspnRepository(nflMapper, espnApi, teamDetailNetworkToModelMapper, rosterMapper, scoreboardMapper)

    @Provides
    fun provideNetworkToTeamDomMapper():  NetworkToTeamDomainModelMapper = NetworkToTeamDomainModelMapper()

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