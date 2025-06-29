interface Move {
    fun move(point: Point)
}

class MoveStraight(private val deltax: Double, private val deltay: Double) : Move {
    override fun move(point: Point) = point.updatePoint(point.x + deltax, point.y + deltay)
}