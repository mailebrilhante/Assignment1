class Circle(center: Point, radius1: Double, radius2: Double) : Ellipse(center, radius1, radius2) {

    init {
        if (radius1 != radius2) {
            throw IllegalArgumentException("Radii must be equal for a circle.")
        }
    }

}