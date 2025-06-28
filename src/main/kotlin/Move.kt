import org.example.Point

interface Move {
    fun move(point: Point) : Point
}

class MoveStraight(private val deltax: Double, private val deltay: Double) : Move {
    override fun move(point: Point) : Point {
        
        val x = point.x + deltax
        val y = point.y + deltay
        
        return Point(x, y, this)
    }
}