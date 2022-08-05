package com.carolmusyoka.dazn.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.dazn.presentation.theme.DaznTheme

@Composable
fun MainDaznApp() {
    DaznTheme {
        val tabs = remember { HomeTabs.values() }
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { DaznBottomBar(tabs = tabs, navController = navController) }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                MainNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}