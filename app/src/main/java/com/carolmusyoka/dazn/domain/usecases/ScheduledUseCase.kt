package com.carolmusyoka.dazn.domain.usecases

import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.scheduled.GetScheduledEventsResponse
import com.carolmusyoka.dazn.domain.repository.MainRepository
import javax.inject.Inject

class ScheduledUseCase  @Inject constructor(private val mainRepository: MainRepository
) {
    suspend fun invoke(): NetworkResult<GetScheduledEventsResponse>{
        return mainRepository.getScheduledEvents()
    }
}
