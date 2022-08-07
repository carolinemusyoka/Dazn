package com.carolmusyoka.dazn.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponse
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponseItem
import com.carolmusyoka.dazn.domain.repository.MainRepository
import com.carolmusyoka.dazn.presentation.screen.PlaybackScreen
import com.carolmusyoka.dazn.presentation.viewmodel.EventViewModel
import com.google.gson.Gson

sealed class MainDestinations(val route: String) {
    object HomeRoute: MainDestinations("home")
    object  EventDetail: MainDestinations("{eventId}/detail")

    fun createRoute(eventId: String) = "$eventId/detail"

}

@Composable
fun MainNavGraph(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    startDestinations: String = MainDestinations.HomeRoute.route,
    eventsViewModel: EventViewModel = hiltViewModel()
){
    val actions = remember {
        MainActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = startDestinations,
    ){
        navigation(
            route = MainDestinations.HomeRoute.route,
            startDestination = HomeTabs.HOME.route,
        ){
            addHomeGraph(
                navController = navController,
                navToPlaybackScreen = {},
                navToEventScreen = {HomeTabs.EVENTS.route},
                navToScheduledScreen = { HomeTabs.SCHEDULED.route },
                modifier = modifier
            )
        }
        composable(
            route = MainDestinations.EventDetail.route,


        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            Log.d("TAG", "NavGraph: eventId: $eventId")
            val events = remember {
                eventsViewModel.getEvents()
                eventsViewModel.events
            }.collectAsState()
            when{
                events.value.data != null ->{
                    val data = events.value.data!![eventId.toInt()]
                    Log.d("TAG", "MainNavGraph: data: $data")
                    PlaybackScreen(
                        navBack = { navController.navigateUp() },
                        modifier = modifier,
                        eventsResponseItem = data
                    )
                }
            }
        }
    }
}
class MainActions(navController: NavHostController) {
    val navigateToPlayback = { eventId: String ->
        navController.navigate(route = "${MainDestinations.EventDetail}/$eventId")
    }
}