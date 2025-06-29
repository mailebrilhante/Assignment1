open class Ellipse(center: Point, private val _radius1: Double, private val _radius2: Double) : Shape(listOf(
    center
)) {

    val center : Point
        get() = points[0]
    val radius1: Double
        get() = _radius1
    val radius2: Double
        get() = _radius2

    init{
        if (radius1 <= 0 || radius2 <= 0) {
            throw IllegalArgumentException("Radii must be positive.")
        }

    }
    
    override fun getAttributes(): List<Any> {
        return listOf(center, radius1, radius2)
    }

    override fun getArea(): Double {
        return Math.PI * radius1 * radius2
    }
}