package com.carolmusyoka.dazn.di

import com.carolmusyoka.dazn.domain.repository.MainRepository
import com.carolmusyoka.dazn.domain.usecases.EventsUseCase
import com.carolmusyoka.dazn.domain.usecases.ScheduledUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideEventsListUseCase(mainRepository: MainRepository) =
        EventsUseCase(mainRepository)

    @Provides
    @Singleton
    fun provideScheduledEventsUseCase(mainRepository: MainRepository) =
        ScheduledUseCase(mainRepository)

}