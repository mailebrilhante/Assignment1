class MoveStraight(private val deltax: Double, private val deltay: Double) : MoveStrategy {
    override fun move(point: Point) = point.updatePoint(point.x + deltax, point.y + deltay)
}