class Square(point1: Point, point2: Point) : Rectangle(point1, point2) {

    init {
        val width = kotlin.math.abs(point1.x - point2.x)
        val height = kotlin.math.abs(point1.y - point2.y)
        if (width != height) {
            throw IllegalArgumentException("Width and height must be the same for a square.")
        }
    }

}