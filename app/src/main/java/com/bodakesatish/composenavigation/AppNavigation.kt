package com.bodakesatish.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bodakesatish.composenavigation.pages.MainPage
import androidx.navigation.compose.composable
import com.bodakesatish.composenavigation.pages.DetailPage
import com.bodakesatish.composenavigation.pages.SearchPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainPage" ){

        composable("mainPage") {
            MainPage(navController = navController)
        }

        composable("searchPage") {
            SearchPage(navController = navController)
        }

        composable("detailPage") {
            DetailPage(navController = navController)
        }
    }

}