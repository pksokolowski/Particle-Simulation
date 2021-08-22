package navigation

sealed class NavDestination(val addToBackStack: Boolean = true) {
    object Previous : NavDestination(false)
    object SimulationScreen : NavDestination()
}