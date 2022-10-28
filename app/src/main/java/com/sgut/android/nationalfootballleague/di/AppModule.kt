package com.sgut.android.nationalfootballleague.di

import com.sgut.android.nationalfootballleague.data.dtomappers.NetworkToTeamDomainModelMapper
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
    fun provideNflRepository(
        espnApi: EspnApi,
        nflMapper: NetworkToTeamDomainModelMapper
    ): EspnRepository = EspnRepository(nflMapper, espnApi)

    @Provides
    fun provideNetworkToTeamDomMapper():  NetworkToTeamDomainModelMapper = NetworkToTeamDomainModelMapper()

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideNflApi(okHttpClient: OkHttpClient): EspnApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EspnApi::class.java)
}