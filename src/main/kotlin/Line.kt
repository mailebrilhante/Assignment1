import org.example.Point
import kotlin.math.sqrt

class Line(
    private val start: Point, 
    private val end: Point
    ) {

    init {
        if (start.x == end.x && start.y == end.y) {
            throw IllegalArgumentException("Start and end points cannot be the same.")
        }
    }
    
    fun getStart() = start

    fun getEnd() = end

    fun getLength(): Double {
        val deltax = end.x - start.x
        val deltay = end.y - start.y
        return sqrt(deltax * deltax + deltay * deltay)
    }

    fun getSlope() = (end.y - start.y) / (end.x - start.x)

    fun setMoveStrategy(newMove: Move){
        start.setMoveStrategy(newMove)
        end.setMoveStrategy(newMove)
    }

    fun moveLine(){
        start.movePoint()
        end.movePoint() 
    }

}
