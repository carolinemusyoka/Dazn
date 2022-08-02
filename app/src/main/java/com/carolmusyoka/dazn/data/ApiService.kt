package com.carolmusyoka.dazn.data

import com.carolmusyoka.dazn.domain.model.events.GetEventsResponse
import com.carolmusyoka.dazn.domain.model.scheduled.GetScheduledEventsResponse
import retrofit2.http.GET

interface ApiService {

    // get all events
    @GET("getEvents")
    suspend fun getEvents(): GetEventsResponse

    // get all scheduled events
    @GET("getSchedule")
    suspend fun getScheduledEvents(): GetScheduledEventsResponse
}