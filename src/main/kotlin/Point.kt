package org.example
import Move
import kotlin.io.print
import kotlin.io.println

class Point(
    private var _x: Double, 
    private var _y: Double, 
    private var moveStrategy: Move? = null
) {

    val x : Double
        get() = _x

    val y : Double
        get() = _y

    
    fun setMoveStrategy(newMove: Move) {
        moveStrategy = newMove
    }
    
    fun movePoint() = moveStrategy?.move(this) ?: println("No move strategy set for this point.")

    fun updatePoint(newX: Double, newY: Double) {
        _x = newX
        _y = newY
    }
    
    fun clonePoint() = Point(x, y, moveStrategy)

}
