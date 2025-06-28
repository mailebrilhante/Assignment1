import org.example.Point

class Square(topLeft: Point, bottomRight: Point) : Rectangle(topLeft, bottomRight) {

    init {
        if (topLeft.x - bottomRight.x != topLeft.y - bottomRight.y) {
            throw IllegalArgumentException("Top left and bottom right points must form a square.")
        }
    }

}