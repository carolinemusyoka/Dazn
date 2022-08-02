package com.carolmusyoka.dazn.domain.model.events

data class GetEventsResponseItem(
    val date: String,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String,
    val videoUrl: String
)