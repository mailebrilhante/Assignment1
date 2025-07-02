import kotlin.math.sqrt

class Line(
    private var _start: Point, 
    private var _end: Point
    ) {

    init {
        if (start.x == end.x && start.y == end.y) {
            throw IllegalArgumentException("Start and end points cannot be the same.")
        }
    }
    
    val start: Point
        get() = _start.clonePoint()
    val end: Point
        get() = _end.clonePoint()

    fun getLength(): Double {
        val deltax = end.x - start.x
        val deltay = end.y - start.y
        return sqrt(deltax * deltax + deltay * deltay)
    }

    fun getSlope() = (end.y - start.y) / (end.x - start.x)

    fun setMoveStrategy(newMove: MoveStrategy){
        _start.setMoveStrategy(newMove)
        _end.setMoveStrategy(newMove)
    }

    fun move(){
        _start.move()
        _end.move()
    }

}
