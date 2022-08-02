package com.carolmusyoka.dazn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.dazn.domain.repository.MainRepository
import com.carolmusyoka.dazn.presentation.screen.PlaybackScreen

sealed class MainDestinations(val route: String) {
    object HomeRoute: MainDestinations("home")
    object  EventDetail: MainDestinations("{eventId}/detail")

    fun createRoute(eventId: String) = "$eventId/detail"
}

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestinations: String = MainDestinations.HomeRoute.route,
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
                modifier = modifier
            )
        }
        composable(
            route = MainDestinations.EventDetail.route,
        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            PlaybackScreen(
                navBack = { navController.navigateUp() },
                modifier = modifier,
                eventId = eventId
            )
        }
    }
}
class MainActions(navController: NavHostController) {
    val navigateToPlayback = { eventId: String ->
        navController.navigate(route = "${MainDestinations.EventDetail}/$eventId")
    }
}