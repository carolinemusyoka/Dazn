package com.carolmusyoka.dazn.domain.usecases

import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponse
import com.carolmusyoka.dazn.domain.repository.MainRepository
import javax.inject.Inject

class EventsUseCase @Inject constructor(private val mainRepository: MainRepository
) {
    suspend fun invoke(): NetworkResult<GetEventsResponse>{
        return mainRepository.getAllEvents()
    }
}
