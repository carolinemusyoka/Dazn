package com.carolmusyoka.dazn.domain.model.scheduled

data class GetScheduledEventsItem(
    val date: String,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String
)