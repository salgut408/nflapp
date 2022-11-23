package com.sgut.android.nationalfootballleague.di

import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkScoreboardToDomainModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.TeamDetailNetworkToModelMapper
import com.sgut.android.nationalfootballleague.data.dtomappers.TeamDetailWithRosterMapper
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.repository.EspnRepository
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}