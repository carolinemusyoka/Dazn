package com.carolmusyoka.dazn.domain.repository

import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponse
import com.carolmusyoka.dazn.domain.model.scheduled.GetScheduledEventsResponse

interface MainRepository {
    suspend fun getAllEvents(): NetworkResult<GetEventsResponse>
    suspend fun getScheduledEvents(): NetworkResult<GetScheduledEventsResponse>
}