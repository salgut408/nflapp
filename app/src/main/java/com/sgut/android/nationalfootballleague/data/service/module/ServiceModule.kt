package com.sgut.android.nationalfootballleague.data.service.module


import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.LogService
import com.sgut.android.nationalfootballleague.data.service.StorageService
import com.sgut.android.nationalfootballleague.data.service.impl.AccountServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.LogServiceImpl
import com.sgut.android.nationalfootballleague.data.service.impl.StorageServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class ServiceModule {
//    @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService
//
//    @Binds abstract fun provideLogService(impl: LogServiceImpl): LogService
//
//    @Binds abstract fun provideStorageService(impl: StorageServiceImpl): StorageService
//
//
//}