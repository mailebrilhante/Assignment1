
import org.example.Point

open class Rectangle(topLeft: Point, bottomRight: Point) : Shape(listOf(
    topLeft,
    bottomRight,
)) {   

    val topLeft: Point
        get() = points[0]
    val bottomRight: Point
        get() = points[1]
    
    init {
        if (topLeft.x == bottomRight.x && topLeft.y == bottomRight.y) {
            throw IllegalArgumentException("Top left and bottom right points cannot be the same.") 
        }
    }

    override fun getArea(): Double {
        val width = bottomRight.x - topLeft.x
        val height = bottomRight.y - topLeft.y
        return width * height
    }

    override fun getAttributes(): List<Any> {
        return listOf(
            "Top Left: (${topLeft.x}, ${topLeft.y})",
            "Bottom Right: (${bottomRight.x}, ${bottomRight.y})",
        )
    }
}