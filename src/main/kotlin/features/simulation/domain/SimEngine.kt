package features.simulation.domain

import features.simulation.model.MutableSimState
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class SimEngine {
    fun progress(state: MutableSimState): MutableSimState {
        state.particles.forEach { p ->
            val newX = xProjectedAtAngle(p.angle, p.speed, p.x)
            val newY = yProjectedAtAngle(p.angle, p.speed, p.y)

            p.x = newX
            p.y = newY
        }
        return state
    }

    private fun xProjectedAtAngle(angle: Double, radius: Double, Xorigin: Double): Double =
        Xorigin + radius * cos(Math.toRadians(angle))

    private fun yProjectedAtAngle(angle: Double, radius: Double, Yorigin: Double): Double =
        Yorigin + radius * sin(Math.toRadians(angle))

    private fun getDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double =
        sqrt((x1 - x2).pow(2.0) + (y1 - y2).pow(2.0))
}