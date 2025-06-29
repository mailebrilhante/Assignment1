import kotlin.math.sqrt

class Line(
    private var _point1: Point, 
    private var _point2: Point
    ) {

    init {
        if (point1.x == point2.x && point1.y == point2.y) {
            throw IllegalArgumentException("Start and end points cannot be the same.")
        }
    }
    
    val point1: Point
        get() = _point1.clonePoint()
    val point2: Point
        get() = _point2.clonePoint()

    fun getLength(): Double {
        val deltax = point2.x - point1.x
        val deltay = point2.y - point1.y
        return sqrt(deltax * deltax + deltay * deltay)
    }

    fun getSlope() = (point2.y - point1.y) / (point2.x - point1.x)

    fun setMoveStrategy(newMove: Move){
        _point1.setMoveStrategy(newMove)
        _point2.setMoveStrategy(newMove)
    }

    fun moveLine(){
        _point1.movePoint()
        _point2.movePoint() 
    }

}
