class Triangle(point1: Point, point2: Point, point3: Point
    ) : Shape(listOf(point1, point2, point3)) {

    val point1: Point
        get() = points[0]
    val point2: Point
        get() = points[1]
    val point3: Point
        get() = points[2]


    init {
        if (!isValidTriangle()) {
            throw IllegalArgumentException("The points do not form a valid triangle.")
        }
    }

    private fun isValidTriangle(): Boolean {
        val area = 0.5 * Math.abs(
            point1.x * (point2.y - point3.y) +
            point2.x * (point3.y - point1.y) +
            point3.x * (point1.y - point2.y)
        )
        return area > 0
    }

    override fun getAttributes(): List<Any> {
        return listOf(point1, point2, point3)
    }

    override fun getArea(): Double {
        return 0.5 * Math.abs(
            point1.x * (point2.y - point3.y) +
            point2.x * (point3.y - point1.y) +
            point3.x * (point1.y - point2.y)
        )
    }
}