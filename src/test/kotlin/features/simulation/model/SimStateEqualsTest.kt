package features.simulation.model

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SimStateEqualsTest {
    @Test
    fun `SimState's equals() works for structurally equivalent objects`() {
        val o1 = MutableSimState(mutableListOf(MutableParticle(1.0, 2.0, MutableEnergy(3.0, 4.0))))
        val o2 = MutableSimState(mutableListOf(MutableParticle(1.0, 2.0, MutableEnergy(3.0, 4.0))))

        assertEquals(o1, o2)
    }

    @Test
    fun `SimState's equals() works for structurally different objects, when difference is within Energy object`() {
        val o1 = MutableSimState(mutableListOf(MutableParticle(1.0, 2.0, MutableEnergy(3.0, 4.0))))
        val o2 = MutableSimState(mutableListOf(MutableParticle(1.0, 2.0, MutableEnergy(4.0, 4.0))))

        assertNotEquals(o1, o2)
    }

    @Test
    fun `SimState's equals() works for structurally different objects, when difference is in integer`() {
        val o1 = MutableSimState(mutableListOf(MutableParticle(1.0, 2.0, MutableEnergy(3.0, 4.0))))
        val o2 = MutableSimState(mutableListOf(MutableParticle(1.0, 3.0, MutableEnergy(3.0, 4.0))))

        assertNotEquals(o1, o2)
    }
}