package com.carolmusyoka.dazn.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.carolmusyoka.dazn.presentation.components.Menu
import com.carolmusyoka.dazn.presentation.components.ScheduledItem
import com.carolmusyoka.dazn.presentation.viewmodel.ScheduledViewModel


@Composable
fun ScheduledScreen(
    navBack: () -> Unit,
    modifier: Modifier = Modifier,
    scheduledViewModel: ScheduledViewModel = hiltViewModel()
){
    val scheduled = remember {
        scheduledViewModel.getScheduledEvents()
        scheduledViewModel.scheduled
    }.collectAsState()

    Scaffold(
        topBar = {
            Menu(
                title = "Scheduled Events",
                pressBack = navBack
            )
        },
        backgroundColor = Color.White,
        content = {
            Column(modifier = Modifier.padding(20.dp)) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)){
                    when {
                        scheduled.value.isLoading ->{

                        }
                        scheduled.value.data != null ->{
                            items(scheduled.value.data!!.size){ scheduledItem ->
                                scheduled.value.data?.get(scheduledItem)?.let {
                                    ScheduledItem(it)
                                }

                            }
                        }
                    }
                }

            }
        }
    )
}