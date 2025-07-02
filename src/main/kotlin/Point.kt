import MoveStrategy
import kotlin.io.print
import kotlin.io.println

class Point(
    private var _x: Double, 
    private var _y: Double, 
    private var moveStrategy: MoveStrategy? = null
) {

    val x : Double
        get() = _x

    val y : Double
        get() = _y

    
    fun setMoveStrategy(newMoveStrategy: MoveStrategy) {
        moveStrategy = newMoveStrategy
    }
    
    fun move() = moveStrategy?.move(this) ?: println("No move strategy set for this point.")

    fun updatePoint(newX: Double, newY: Double) {
        _x = newX
        _y = newY
    }
    
    fun clonePoint() = Point(x, y, moveStrategy)

}
