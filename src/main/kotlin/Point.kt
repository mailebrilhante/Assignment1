package org.example

import Move

class Point(
    private var _x: Double, 
    private var _y: Double, 
    private var moveStrategy: Move
) {

    val x : Double
        get() = _x

    val y : Double
        get() = _y

    fun move() = moveStrategy.move(this)
    
    fun setMoveStrategy(newMove: Move) {
        moveStrategy = newMove
    }
}
