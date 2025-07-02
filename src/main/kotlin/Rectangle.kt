open class Rectangle(topLeft: Point, bottomRight: Point
    ) : Shape(listOf(topLeft, bottomRight,)) {

    val topLeft: Point
        get() = points[0]
    val bottomRight: Point
        get() = points[1]
    
    init {
        if (topLeft.x == bottomRight.x || topLeft.y == bottomRight.y) {
            throw IllegalArgumentException("Rectangle cannot have zero width or height.") 
        }
    }

    override fun getArea(): Double {
        val width = kotlin.math.abs(bottomRight.x - topLeft.x)
        val height = kotlin.math.abs(bottomRight.y - topLeft.y)
        return width * height
    }

    override fun getAttributes(): List<Any> {
        return listOf(topLeft, bottomRight)
    }
}