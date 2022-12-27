package xyz.davitkamavosyan.app.ui.navigation sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEvent : Screen("add_event")
    object EventDetails : Screen("event_details")
}