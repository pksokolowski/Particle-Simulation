package features.simulation.model

interface SimState {
    val particles: List<Particle>
}

data class MutableSimState(
    override val particles: MutableList<MutableParticle>
) : SimState


interface Particle {
    val x: Double
    val y: Double
    val angle: Double
    val speed: Double
}

data class MutableParticle(
    override var x: Double,
    override var y: Double,
    override var angle: Double,
    override var speed: Double,
) : Particle
