import org.example.Point

abstract class Shape (private var _points: List<Point>) {

    val points: List<Point>
        get() = _points

    fun setMoveStrategy(move: Move) { 
        for (point in points) {
            point.setMoveStrategy(move)
        }
    }

    fun moveShape() {
       for (point in points) {
            point.movePoint()
        }
    }

    abstract fun getAttributes(): List<Any>
    abstract fun getArea(): Double

    
}
