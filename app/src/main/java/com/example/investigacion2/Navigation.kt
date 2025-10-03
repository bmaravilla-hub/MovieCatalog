package com.example.investigacion2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.investigacion2.components.FavoritesScreen
import com.example.investigacion2.components.MovieDetailScreen
import com.example.investigacion2.model.sampleMovies

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object MovieDetail : Screen("movie_detail")
    object Favorites : Screen("favorites")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(Screen.MovieList.route) {
            MovieCatalogApp(
                onMovieClick = { movieId ->
                    navController.navigate("${Screen.MovieDetail.route}/$movieId")
                },
                onFavoritesClick = {
                    navController.navigate(Screen.Favorites.route)
                }
            )
        }

        composable(
            route = "${Screen.MovieDetail.route}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            val movie = sampleMovies.find { it.id == movieId } ?: sampleMovies[0]
            MovieDetailScreen(movie = movie, navController = navController)
        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(
                navController = navController,
                onMovieClick = { movieId ->
                    navController.navigate("${Screen.MovieDetail.route}/$movieId")
                }
            )
        }
    }
}