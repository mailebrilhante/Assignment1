open class Rectangle(point1: Point, point2: Point
    ) : Shape(listOf(point1, point2,)) {

    val point1: Point
        get() = points[0]
    val point2: Point
        get() = points[1]
    
    init {
        if (point1.x == point2.x || point1.y == point2.y) {
            throw IllegalArgumentException("Rectangle cannot have zero width or height.") 
        }
    }

    override fun getArea(): Double {
        val width = kotlin.math.abs(point2.x - point1.x)
        val height = kotlin.math.abs(point2.y - point1.y)
        return width * height
    }

    override fun getAttributes(): List<Any> {
        return listOf(point1, point2)
    }
}