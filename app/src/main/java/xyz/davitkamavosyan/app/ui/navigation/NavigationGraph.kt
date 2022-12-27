package xyz.davitkamavosyan.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.getViewModel
import xyz.davitkamavosyan.app.ui.screens.addevent.AddEventScreen
import xyz.davitkamavosyan.app.ui.screens.event.EventDetailsScreen
import xyz.davitkamavosyan.app.ui.screens.home.HomeScreen


@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navigationViewModel: NavigationViewModel = getViewModel(),
    navController: NavHostController
) {
    LaunchedEffect(navigationViewModel.effect) {
        navigationViewModel.effect.collect { effect ->
            when (effect) {
                NavigationViewModel.Effect.OnBackPressed -> {
                    navController.popBackStack()
                }
                is NavigationViewModel.Effect.ShowAddEvent -> {
                    navController.navigate(Screen.AddEvent.route + "/${effect.eventId}")
                }
                is NavigationViewModel.Effect.ShowEventDetails ->{
                    navController.navigate(Screen.EventDetails.route + "/${effect.eventId}")
                }
            }
        }
    }
    NavHost(
        modifier = modifier, navController = navController, startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navigationViewModel = navigationViewModel)
        }
        composable(Screen.AddEvent.route + "/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")?.toLongOrNull()
            AddEventScreen(
                eventId = eventId,
                navigationViewModel = navigationViewModel
            )
        }
        composable(Screen.EventDetails.route + "/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")?.toLong()
            EventDetailsScreen(
                eventId = eventId, navigationViewModel = navigationViewModel
            )
        }
    }
}
