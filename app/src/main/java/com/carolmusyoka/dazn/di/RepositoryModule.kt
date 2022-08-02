package com.carolmusyoka.dazn.di

import com.carolmusyoka.dazn.data.repository.MainRepositoryImpl
import com.carolmusyoka.dazn.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}