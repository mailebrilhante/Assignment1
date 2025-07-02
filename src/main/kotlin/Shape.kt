abstract class Shape (private var _points: List<Point>) {

    val points: List<Point>
        get() = _points.map { it.clonePoint() }

    fun setMoveStrategy(move: MoveStrategy) {
        for (point in _points) {
            point.setMoveStrategy(move)
        }
    }

    fun move() {
       for (point in _points) {
            point.move()
        }
    }

    abstract fun getAttributes(): List<Any>
    abstract fun getArea(): Double

    
}
