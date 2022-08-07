package com.carolmusyoka.dazn.domain.model.scheduled

data class ScheduledUiState(
    val isLoading: Boolean = false,
    val data: GetScheduledEventsResponse? = null,
    val error: Boolean = false
)