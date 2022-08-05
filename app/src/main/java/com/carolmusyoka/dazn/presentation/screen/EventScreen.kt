package com.carolmusyoka.dazn.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.carolmusyoka.dazn.presentation.components.EventsItem
import com.carolmusyoka.dazn.presentation.components.Menu
import com.carolmusyoka.dazn.presentation.viewmodel.EventViewModel

@Composable
fun EventScreen(
    navBack:() -> Unit,
    navToPlaybackScreen:() -> Unit,
    modifier: Modifier = Modifier,
    eventsViewModel: EventViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val events = remember {
        eventsViewModel.getEvents()
        eventsViewModel.events
    }.collectAsState()


    Scaffold(
        topBar = {
            Menu(
                title = "All Events",
                pressBack = navBack
            )
        },
        backgroundColor = Color.White,
        content = {
            Column(modifier = Modifier.padding(30.dp)) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    when {
                        events.value.isLoading -> {

                        }
                        events.value.data != null -> {
                            items(events.value.data!!.size) { event ->
                                events.value.data?.get(event)?.let {
                                    EventsItem(it, navToPlaybackScreen)
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    )
}
