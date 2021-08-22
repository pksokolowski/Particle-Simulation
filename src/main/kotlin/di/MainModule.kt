package di

import features.simulation.presentation.ISimulationViewModel
import features.simulation.presentation.SimulationViewModel
import navigation.Navigator
import navigation.ScreenBackStack
import org.koin.dsl.module

val mainModule = module {
    single { Navigator() }
    factory { ScreenBackStack() }
    factory { SimulationViewModel() as ISimulationViewModel }
}