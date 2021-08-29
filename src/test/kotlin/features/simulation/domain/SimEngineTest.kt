package features.simulation.domain

import features.simulation.model.MutableEnergy
import features.simulation.model.MutableParticle
import features.simulation.model.MutableSimState
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SimEngineTest {

    @Test
    fun `particles without energy stay still`() {
        val state = MutableSimState(
            particles = mutableListOf(MutableParticle(1.0, 1.0, MutableEnergy(0.0, 0.0)))
        )

        engine.progress(state)

        val expectedState = MutableSimState(
            particles = mutableListOf(MutableParticle(1.0, 1.0, MutableEnergy(0.0, 0.0)))
        )

        assertEquals(expectedState, state)
    }

    @Test
    fun `a single particle with energy of 1, moves by 1 in the right direction, conserving energy, in a single tick`() {
        val state = MutableSimState(
            particles = mutableListOf(MutableParticle(1.0, 1.0, MutableEnergy(0.0, 1.0)))
        )

        val endState = engine.progress(state)

        val expectedState = MutableSimState(
            particles = mutableListOf(MutableParticle(2.0, 1.0, MutableEnergy(0.0, 1.0)))
        )

        assertEquals(expectedState, endState)
    }

    private val engine = SimEngine()
}