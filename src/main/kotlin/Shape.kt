import org.example.Point

abstract class Shape (private var _points : List<Point>) {


    val points: List<Point>
        get() = _points
    
    fun moveStrategy(move: Move) { 
        points.forEach{point ->
            point.setMoveStrategy(move)
        }
    }

    fun moveShape() {
        points.forEach { point ->
            point.movePoint()
        }
    }

    abstract fun getAttributes(): List<Any>
    abstract fun getArea(): Double

    
}
