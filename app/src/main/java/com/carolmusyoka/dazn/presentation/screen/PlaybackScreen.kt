package com.carolmusyoka.dazn.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponseItem
import com.carolmusyoka.dazn.presentation.components.Menu
import com.carolmusyoka.dazn.presentation.components.Title


@Composable
fun PlaybackScreen(
    navBack:() -> Unit,
    modifier: Modifier = Modifier,
    eventsResponseItem: GetEventsResponseItem
){
    Scaffold(
        topBar = {
            Menu(
                title = "Video Playback",
                pressBack = navBack
            )
        },
        backgroundColor = Color.White,
        content = {
           
        }
    )
}
