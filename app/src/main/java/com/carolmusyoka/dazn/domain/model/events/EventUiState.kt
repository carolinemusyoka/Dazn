package com.carolmusyoka.dazn.domain.model.events

data class EventUiState(
    val isLoading: Boolean = false,
    val data: GetEventsResponse? = null,
    val error: Boolean = false
)