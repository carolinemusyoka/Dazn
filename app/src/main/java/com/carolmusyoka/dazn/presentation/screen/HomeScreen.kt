package com.carolmusyoka.dazn.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.dazn.domain.model.events.EventUiState
import com.carolmusyoka.dazn.domain.model.scheduled.ScheduledUiState
import com.carolmusyoka.dazn.presentation.components.EventCardItem
import com.carolmusyoka.dazn.presentation.components.ScheduledCardItem
import com.carolmusyoka.dazn.presentation.components.Title
import com.carolmusyoka.dazn.presentation.theme.subTitleTextColor
import com.carolmusyoka.dazn.presentation.theme.titleTextColor
import com.carolmusyoka.dazn.presentation.viewmodel.EventViewModel
import com.carolmusyoka.dazn.presentation.viewmodel.ScheduledViewModel

@Composable
fun HomeScreen(
    navToEventsScreen:() -> Unit,
    navToScheduledScreen:() -> Unit,
    modifier: Modifier = Modifier,
    navToPlaybackScreen:() -> Unit,
    navController: NavController,
    eventsViewModel: EventViewModel = hiltViewModel(),
    scheduledViewModel: ScheduledViewModel = hiltViewModel()
){
    val scrollState = rememberScrollState()
    val events = remember {
        eventsViewModel.getEvents()
        eventsViewModel.events
    }.collectAsState()

    val scheduled = remember {
        scheduledViewModel.getScheduledEvents()
        scheduledViewModel.scheduled
    }.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ){
        Column(modifier = Modifier.padding(30.dp)) {

            // maybe add a custom topBar
            HomeTitle()
            Spacer(modifier = Modifier.height(24.dp))

            EventsHorizontalList(events, navController)

            Spacer(modifier = Modifier.height(24.dp))

            ScheduledHorizontalList(scheduled, navController)

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun HomeTitle() {
    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        // Call Text
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(
                        style = SpanStyle(
                            color = subTitleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("Hi there\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = titleTextColor,
                            fontSize = 24.sp
                        )
                    ) {
                        append("Welcome to Dazn!")
                    }
                }
            }
        )
    }
}

@Composable
fun ScheduledHorizontalList(scheduled: State<ScheduledUiState>, navController: NavController) {
    Column{
        // Row of title and show more button(transparent button)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Scheduled",
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 6.dp)
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                Modifier
                    .background(color = Color.Transparent),
            ) {
                // Populate the star rating
                Text(text = "View all", color = Color.DarkGray)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Row of scheduled events
        LazyRow{
            when{
                scheduled.value.isLoading -> {
                    // loading
                }
                scheduled.value.data != null ->{
                    items(scheduled.value.data!!.size){ event ->
                        scheduled.value.data?.get(event)?.let {
                            ScheduledCardItem(it,
                                navController = navController
                            )
                        }
                    }
                }
                scheduled.value.error -> {
                    // error
                }
            }
        }

    }
}

@Composable
fun EventsHorizontalList(events: State<EventUiState>, navController: NavController) {
    Column{
        // Row of title and show more button(transparent button)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Events",
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 6.dp)
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                Modifier
                    .background(color = Color.Transparent),
            ) {
                // Populate the star rating
                Text(text = "View all", color = Color.DarkGray)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Row of events
        LazyRow{
            when{
                events.value.isLoading -> {
                    // loading
                }
                events.value.data != null ->{
                    items(events.value.data!!.size){ event ->
                        events.value.data?.get(event)?.let {
                            EventCardItem(eventsResponseItem = it,
                                navController = navController
                            )
                        }
                    }
                }
                events.value.error -> {
                    // error
                }
            }
        }

    }
}

@Preview
@Composable
fun EventsHorizontalListPreview(){
}
