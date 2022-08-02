package com.carolmusyoka.dazn.data.repository

import com.carolmusyoka.dazn.data.ApiService
import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponse
import com.carolmusyoka.dazn.domain.model.scheduled.GetScheduledEventsResponse
import com.carolmusyoka.dazn.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor (private val apiService: ApiService): MainRepository, BaseRepository(){
    override suspend fun getAllEvents(): NetworkResult<GetEventsResponse> {
        return safeApiCall { apiService.getEvents() }
    }

    override suspend fun getScheduledEvents(): NetworkResult<GetScheduledEventsResponse> {
        return safeApiCall { apiService.getScheduledEvents() }
    }
}