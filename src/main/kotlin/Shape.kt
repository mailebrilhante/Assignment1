abstract class Shape (private var _points: List<Point>) {

    val points: List<Point>
        get() = _points.map { it.clonePoint() }

    fun setMoveStrategy(move: Move) { 
        for (point in _points) {
            point.setMoveStrategy(move)
        }
    }

    fun moveShape() {
       for (point in _points) {
            point.movePoint()
        }
    }

    abstract fun getAttributes(): List<Any>
    abstract fun getArea(): Double

    
}
