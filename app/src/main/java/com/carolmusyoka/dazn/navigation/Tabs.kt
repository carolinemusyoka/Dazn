package com.carolmusyoka.dazn.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.EventAvailable
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.carolmusyoka.dazn.presentation.screen.EventScreen
import com.carolmusyoka.dazn.presentation.screen.HomeScreen
import com.carolmusyoka.dazn.presentation.screen.ScheduledScreen

enum class HomeTabs(
    val title: String,
    val icon: ImageVector,
    val route: String
){
    HOME("Home", Icons.Rounded.Home, "tabs/home"),
    EVENTS("Events", Icons.Rounded.History, "tabs/events"),
    SCHEDULED("Schedule", Icons.Rounded.Event, "tabs/scheduled"),
}

fun NavGraphBuilder.addHomeGraph(
    navController: NavController,
    navToPlaybackScreen: () -> Unit,
    navToEventScreen: () -> Unit,
    navToScheduledScreen: () -> Unit,
    modifier: Modifier = Modifier
){
    composable(HomeTabs.HOME.route){
        HomeScreen(
            navToEventsScreen = {navController.navigate(HomeTabs.EVENTS.route)},
            navToScheduledScreen = {navController.navigate(HomeTabs.SCHEDULED.route)},
            navController = navController,
            navToPlaybackScreen = {  },
            modifier = modifier
        )
    }
    composable(HomeTabs.EVENTS.route){
        EventScreen(
            navBack = { navController.navigateUp()},
            navToPlaybackScreen = navToPlaybackScreen,
            modifier = modifier
        )
    }
    composable(HomeTabs.SCHEDULED.route){
        ScheduledScreen(
            navBack = { navController.navigateUp()},
            modifier = modifier
        )
    }
}

@Composable
fun DaznBottomBar(
    navController: NavController,
    tabs: Array<HomeTabs>
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HomeTabs.HOME.route

    val routes = remember { HomeTabs.values().map { it.route } }

    if (currentRoute in routes){
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = tab.icon, contentDescription = tab.title) },
                    label = { Text(text = tab.title) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (currentRoute != tab.route){
                            navController.navigate(tab.route)
                        }
                    },
                    alwaysShowLabel = false
                )

            }

        }
    }
}