import androidx.compose.desktop.Window
import androidx.compose.runtime.collectAsState
import di.mainModule
import features.simulation.presentation.SimulationScreen
import navigation.NavDestination
import navigation.Navigator
import navigation.ScreenBackStack
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject

fun main() {
    startKoin {
        modules(mainModule)
    }

    val navigator: Navigator by inject(Navigator::class.java)
    navigator.navigateTo(NavDestination.SimulationScreen)

    val backStack: ScreenBackStack by inject(ScreenBackStack::class.java)

    Window {
        val navDestinationState = navigator.currentScreen.collectAsState()
        val destination = navDestinationState.value

        val screen = when (destination) {
            is NavDestination.Previous -> {
                backStack.getPrevious()
            }
            is NavDestination.SimulationScreen -> {
                SimulationScreen()
            }
            null -> {
                null
            }
        }

        if (destination?.addToBackStack == true) backStack.put(screen)
        screen?.render()
    }
}