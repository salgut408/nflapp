package com.sgut.android.nationalfootballleague.di

import com.sgut.android.nationalfootballleague.data.dtomappers.NflToTeamDomainModelMapper
import com.sgut.android.nationalfootballleague.data.remote.api.NflApi
import com.sgut.android.nationalfootballleague.repository.NflRepository
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
        nflApi: NflApi,
        nflMapper: NflToTeamDomainModelMapper
    ): NflRepository = NflRepository(nflMapper, nflApi)

    @Provides
    fun provideNflResponseMapper():  NflToTeamDomainModelMapper = NflToTeamDomainModelMapper()

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideNflApi(okHttpClient: OkHttpClient): NflApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NflApi::class.java)

}