import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import MoveStraight
import kotlin.test.assertEquals
import kotlin.math.abs
import kotlin.math.sqrt

class TestAssignment1 {
   
    // ======Tests for Point Class =====
    @Test
    fun testMove() {
        val point = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        point.move()
        assertEquals(1.0, point.x)
        assertEquals(1.0, point.y)
    }

    @Test
    fun testSetMoveStrategy() {
        val point = Point(0.0, 0.0, null)
        point.setMoveStrategy(MoveStraight(1.0, 1.0))
        point.move()
        assertEquals(1.0, point.x)
        assertEquals(1.0, point.y)
    }

    @Test
    fun testClonePoint() {
        val point = Point(0.0, 0.0, null)
        val newPoint = point.clonePoint()
        assertEquals(point.x, newPoint.x)
        assertEquals(point.y, newPoint.y)
    }

    @Test
    fun testMoveWithNullStrategy() {
        val point = Point(0.0, 0.0, null)
        point.move()
        assertEquals(0.0, point.x)
        assertEquals(0.0, point.y)
    }

   
    // ======Tests for Line Class =====
    @Test
    fun testIdenticalStartandEnd(){
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(0.0, 0.0, null)
        assertThrows<IllegalArgumentException> {
            val line = Line(point1, point2)
        }
    }

    @Test
    fun testGetLength(){
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(3.0, 4.0, null)
        val line = Line(point1, point2)
        assertEquals(5.0, line.getLength())
    }

    @Test
    fun testGetLengthWithNegativeCoordinates(){
        val point1 = Point(-1.0, -2.0, null)
        val point2 = Point(2.0, 2.0, null)
        val line = Line(point1, point2)
        assertEquals(5.0, line.getLength())
    }

    @Test
    fun testGetSlope() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(1.0, 1.0, null)
        val line = Line(point1, point2)
        assertEquals(1.0, line.getSlope())
    }

    @Test
    fun testGetSlopeHorizontal() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(5.0, 0.0, null)
        val line = Line(point1, point2)
        assertEquals(0.0, line.getSlope())
    }

    @Test
    fun testGetSlopeVertical() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(0.0, 5.0, null)
        val line = Line(point1, point2)
        assertEquals(Double.POSITIVE_INFINITY, line.getSlope())
    }

    @Test
    fun testMoveforLine(){
        val point1 = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val point2 = Point(1.0, 1.0, MoveStraight(1.0, 1.0))
        val line = Line(point1, point2)
        line.move()
        assertEquals(1.0, line.start.x)
        assertEquals(1.0, line.start.y)
        assertEquals(2.0, line.end.x)
        assertEquals(2.0, line.end.y)
    }

    @Test
    fun testMoveLineWithNegativeDelta(){
        val point1 = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val point2 = Point(1.0, 1.0, MoveStraight(-1.0, -1.0))
        val line = Line(point1, point2)
        line.move()
        assertEquals(-1.0, line.start.x)
        assertEquals(-1.0, line.start.y)
        assertEquals(0.0, line.end.x)
        assertEquals(0.0, line.end.y)
    }

    @Test
    fun testSetMoveStrategyLine() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(1.0, 1.0, null)
        val line = Line(point1, point2)
        line.setMoveStrategy(MoveStraight(1.0, 1.0))
        line.move()
        assertEquals(1.0, line.start.x)
        assertEquals(1.0, line.start.y)
        assertEquals(2.0, line.end.x)
        assertEquals(2.0, line.end.y)
    }

    // ======Tests for Rectangle Class =====

    @Test
    fun testRectangleCreation() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val rectangle = Rectangle(point1, point2)
        assertEquals(point1.x, rectangle.topLeft.x)
        assertEquals(point1.y, rectangle.topLeft.y)
        assertEquals(point2.x, rectangle.bottomRight.x)
        assertEquals(point2.y, rectangle.bottomRight.y)
    }

    @Test
    fun testRectangleCreationWithInvertedCoordinates() {
        val point1 = Point(2.0, 2.0, null)
        val point2 = Point(0.0, 0.0, null)
        val rectangle = Rectangle(point1, point2)
        assertEquals(point1.x, rectangle.topLeft.x)
        assertEquals(point1.y, rectangle.topLeft.y)
        assertEquals(point2.x, rectangle.bottomRight.x)
        assertEquals(point2.y, rectangle.bottomRight.y)
    }

    @Test
    fun testInvalidRectangle() {
        val point1 = Point(1.0, 1.0, null)
        val point2 = Point(1.0, 1.0, null)
        assertThrows<IllegalArgumentException> {
            Rectangle(point1, point2)
        }
    }

    @Test
    fun testInvalidRectangleZeroWidth() {
        val point1 = Point(1.0, 1.0, null)
        val point2 = Point(1.0, 5.0, null)
        assertThrows<IllegalArgumentException> {
            Rectangle(point1, point2)
        }
    }

    @Test
    fun testInvalidRectangleZeroHeight() {
        val point1 = Point(1.0, 1.0, null)
        val point2 = Point(5.0, 1.0, null)
        assertThrows<IllegalArgumentException> {
            Rectangle(point1, point2)
        }
    }

    @Test
    fun testGetRectangleArea() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 3.0, null)
        val rectangle = Rectangle(point1, point2)
        assertEquals(6.0, rectangle.getArea())
    }

    @Test
    fun testGetRectangleAreaWithNegativeCoordinates() {
        val point1 = Point(-2.0, -3.0, null)
        val point2 = Point(2.0, 3.0, null)
        val rectangle = Rectangle(point1, point2)
        assertEquals(24.0, rectangle.getArea())
    }

    @Test
    fun testGetRectangleAreaWithInvertedCoordinates() {
        val point1 = Point(2.0, 3.0, null)
        val point2 = Point(0.0, 0.0, null)
        val rectangle = Rectangle(point1, point2)
        assertEquals(6.0, rectangle.getArea())
    }

    @Test
    fun testGetRectangleAttributes() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 3.0, null)
        val rectangle = Rectangle(point1, point2)
        val attributes = rectangle.getAttributes() as List<Point>
        assertEquals(point1.x, attributes[0].x)
        assertEquals(point1.y, attributes[0].y)
        assertEquals(point2.x, attributes[1].x)
        assertEquals(point2.y, attributes[1].y)
    }
    @Test
    fun testMoveRectangle() {
        val point1 = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val point2 = Point(2.0, 2.0, MoveStraight(1.0, 1.0))
        val rectangle = Rectangle(point1, point2)
        rectangle.move()
        assertEquals(1.0, rectangle.topLeft.x)
        assertEquals(1.0, rectangle.topLeft.y)
        assertEquals(3.0, rectangle.bottomRight.x)
        assertEquals(3.0, rectangle.bottomRight.y)
    }

    @Test
    fun testMoveRectangleWithNegativeDelta() {
        val point1 = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val point2 = Point(2.0, 2.0, MoveStraight(-1.0, -1.0))
        val rectangle = Rectangle(point1, point2)
        rectangle.move()
        assertEquals(-1.0, rectangle.topLeft.x)
        assertEquals(-1.0, rectangle.topLeft.y)
        assertEquals(1.0, rectangle.bottomRight.x)
        assertEquals(1.0, rectangle.bottomRight.y)
    }

    @Test
    fun testSetMoveStrategyRectangle() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val rectangle = Rectangle(point1, point2)
        rectangle.setMoveStrategy(MoveStraight(1.0, 1.0))
        rectangle.move()
        assertEquals(1.0, rectangle.topLeft.x)
        assertEquals(1.0, rectangle.topLeft.y)
        assertEquals(3.0, rectangle.bottomRight.x)
        assertEquals(3.0, rectangle.bottomRight.y)
    }

    // ===== Test for Square Class =====
    @Test
    fun testSquareCreation() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val square = Square(point1, point2)
        assertEquals(point1.x, square.topLeft.x)
        assertEquals(point1.y, square.topLeft.y)
        assertEquals(point2.x, square.bottomRight.x)
        assertEquals(point2.y, square.bottomRight.y)
    }

    @Test
    fun testSquareCreationWithInvertedCoordinates() {
        val point1 = Point(2.0, 0.0, null)
        val point2 = Point(0.0, 2.0, null)
        val square = Square(point1, point2)
        assertEquals(point1.x, square.topLeft.x)
        assertEquals(point1.y, square.topLeft.y)
        assertEquals(point2.x, square.bottomRight.x)
        assertEquals(point2.y, square.bottomRight.y)
    }

    @Test
    fun testInvalidSquare() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 3.0, null)
        assertThrows<IllegalArgumentException> {
            Square(point1, point2)
        }
    }
    @Test
    fun testMoveSquare() {
        val point1 = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val point2 = Point(2.0, 2.0, MoveStraight(1.0, 1.0))
        val square = Square(point1, point2)
        square.move()
        assertEquals(1.0, square.topLeft.x)
        assertEquals(1.0, square.topLeft.y)
        assertEquals(3.0, square.bottomRight.x)
        assertEquals(3.0, square.bottomRight.y)
    }
    @Test
    fun testGetSquareArea() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val square = Square(point1, point2)
        assertEquals(4.0, square.getArea())
    }

    @Test
    fun testGetSquareAreaWithNegativeCoordinates() {
        val point1 = Point(-2.0, -2.0, null)
        val point2 = Point(2.0, 2.0, null)
        val square = Square(point1, point2)
        assertEquals(16.0, square.getArea())
    }

    @Test
    fun testGetSquareAttributes() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val square = Square(point1, point2)
        val attributes = square.getAttributes() as List<Point>
        assertEquals(point1.x, attributes[0].x)
        assertEquals(point1.y, attributes[0].y)
        assertEquals(point2.x, attributes[1].x)
        assertEquals(point2.y, attributes[1].y)
    }

    @Test
    fun testMoveSquareWithNegativeDelta() {
        val point1 = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val point2 = Point(2.0, 2.0, MoveStraight(-1.0, -1.0))
        val square = Square(point1, point2)
        square.move()
        assertEquals(-1.0, square.topLeft.x)
        assertEquals(-1.0, square.topLeft.y)
        assertEquals(1.0, square.bottomRight.x)
        assertEquals(1.0, square.bottomRight.y)
    }

    @Test
    fun testSetMoveStrategySquare() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(2.0, 2.0, null)
        val square = Square(point1, point2)
        square.setMoveStrategy(MoveStraight(1.0, 1.0))
        square.move()
        assertEquals(1.0, square.topLeft.x)
        assertEquals(1.0, square.topLeft.y)
        assertEquals(3.0, square.bottomRight.x)
        assertEquals(3.0, square.bottomRight.y)
    }

    // ======Tests for Ellipse Class =====
    @Test
    fun testEllipseCreation() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        assertEquals(center.x, ellipse.center.x)
        assertEquals(center.y, ellipse.center.y)
        assertEquals(radius1, ellipse.radius1)
        assertEquals(radius2, ellipse.radius2)
    }

    @Test
    fun testInvalidEllipseNegativeRadius() {
        val center = Point(0.0, 0.0, null)
        val radius1 = -1.0
        val radius2 = 2.0
        assertThrows<IllegalArgumentException> {
            Ellipse(center, radius1, radius2)
        }
    }

    @Test
    fun testInvalidEllipseZeroRadius() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 0.0
        val radius2 = 2.0
        assertThrows<IllegalArgumentException> {
            Ellipse(center, radius1, radius2)
        }
    }

    @Test
    fun testInvalidEllipseSecondRadiusOnly() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 0.0
        assertThrows<IllegalArgumentException> {
            Ellipse(center, radius1, radius2)
        }
    }

    @Test
    fun testGetEllipseArea() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        assertEquals(Math.PI * radius1 * radius2, ellipse.getArea())
    }

    @Test
    fun testGetEllipseAreaWithNegativeCenter() {
        val center = Point(-1.0, -1.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        assertEquals(Math.PI * radius1 * radius2, ellipse.getArea())
    }

    @Test
    fun testGetEllipseAttributes() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        val attributes = ellipse.getAttributes()
        val attrCenter = attributes[0] as Point
        assertEquals(center.x, attrCenter.x)
        assertEquals(center.y, attrCenter.y)
        assertEquals(radius1, attributes[1])
        assertEquals(radius2, attributes[2])
    }
    @Test
    fun testMoveEllipse() {
        val center = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        ellipse.move()
        assertEquals(1.0, ellipse.center.x)
        assertEquals(1.0, ellipse.center.y)
    }

    @Test
    fun testMoveEllipseWithNegativeDelta() {
        val center = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        ellipse.move()
        assertEquals(-1.0, ellipse.center.x)
        assertEquals(-1.0, ellipse.center.y)
    }

    @Test
    fun testSetMoveStrategyEllipse() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        ellipse.setMoveStrategy(MoveStraight(1.0, 1.0))
        ellipse.move()
        assertEquals(1.0, ellipse.center.x)
        assertEquals(1.0, ellipse.center.y)
    }

    // ======Tests for Circle Class =====
    @Test
    fun testCircleCreation() {
        val center = Point(0.0, 0.0, null)
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        assertEquals(center.x, circle.center.x)
        assertEquals(center.y, circle.center.y)
        assertEquals(radius, circle.radius1)
        assertEquals(radius, circle.radius2)
    }
    @Test
    fun testInvalidCircle() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 4.0
        assertThrows<IllegalArgumentException> {
            Circle(center, radius1, radius2)
        }
    }

    @Test
    fun testInvalidCircleNegativeRadius() {
        val center = Point(0.0, 0.0, null)
        val radius1 = -3.0
        val radius2 = -3.0
        assertThrows<IllegalArgumentException> {
            Circle(center, radius1, radius2)
        }
    }

    @Test
    fun testGetCircleArea() {
        val center = Point(0.0, 0.0, null)
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        assertEquals(Math.PI * radius * radius, circle.getArea())
    }

    @Test
    fun testGetCircleAreaWithNegativeCenter() {
        val center = Point(-1.0, -1.0, null)
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        assertEquals(Math.PI * radius * radius, circle.getArea())
    }

    @Test
    fun testGetCircleAttributes() {
        val center = Point(0.0, 0.0, null)
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        val attributes = circle.getAttributes()
        val attrCenter = attributes[0] as Point
        assertEquals(center.x, attrCenter.x)
        assertEquals(center.y, attrCenter.y)
        assertEquals(radius, attributes[1])
        assertEquals(radius, attributes[2])
    }
    @Test
    fun testMoveCircle() {
        val center = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        circle.move()
        assertEquals(1.0, circle.center.x)
        assertEquals(1.0, circle.center.y)
    }

    @Test
    fun testMoveCircleWithNegativeDelta() {
        val center = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        circle.move()
        assertEquals(-1.0, circle.center.x)
        assertEquals(-1.0, circle.center.y)
    }

    @Test
    fun testSetMoveStrategyCircle() {
        val center = Point(0.0, 0.0, null)
        val radius = 3.0
        val circle = Circle(center, radius, radius)
        circle.setMoveStrategy(MoveStraight(1.0, 1.0))
        circle.move()
        assertEquals(1.0, circle.center.x)
        assertEquals(1.0, circle.center.y)
    }

    // ======Tests for Triangle Class =====
    @Test
    fun testTriangleCreation() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(3.0, 0.0, null)
        val point3 = Point(1.5, 2.0, null)
        val triangle = Triangle(point1, point2, point3)
        assertEquals(point1.x, triangle.point1.x)
        assertEquals(point1.y, triangle.point1.y)
        assertEquals(point2.x, triangle.point2.x)
        assertEquals(point2.y, triangle.point2.y)
        assertEquals(point3.x, triangle.point3.x)
        assertEquals(point3.y, triangle.point3.y)
    }
    @Test
    fun testInvalidTriangle() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(1.0, 1.0, null)
        val point3 = Point(2.0, 2.0, null)
        assertThrows<IllegalArgumentException> {
            Triangle(point1, point2, point3)
        }
    }
    @Test
    fun testGetTriangleArea() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(3.0, 0.0, null)
        val point3 = Point(1.5, 2.0, null)
        val triangle = Triangle(point1, point2, point3)
        assertEquals(3.0, triangle.getArea(), 0.001)
    }

    @Test
    fun testGetTriangleAreaWithNegativeCoordinates() {
        val point1 = Point(-1.0, -1.0, null)
        val point2 = Point(2.0, -1.0, null)
        val point3 = Point(0.5, 1.0, null)
        val triangle = Triangle(point1, point2, point3)
        assertEquals(3.0, triangle.getArea(), 0.001)
    }

    @Test
    fun testGetTriangleAttributes() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(3.0, 0.0, null)
        val point3 = Point(1.5, 2.0, null)
        val triangle = Triangle(point1, point2, point3)
        val attributes = triangle.getAttributes() as List<Point>
        assertEquals(point1.x, attributes[0].x)
        assertEquals(point1.y, attributes[0].y)
        assertEquals(point2.x, attributes[1].x)
        assertEquals(point2.y, attributes[1].y)
        assertEquals(point3.x, attributes[2].x)
        assertEquals(point3.y, attributes[2].y)
    }
    @Test
    fun testMoveTriangle() {
        val point1 = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val point2 = Point(3.0, 0.0, MoveStraight(1.0, 1.0))
        val point3 = Point(1.5, 2.0, MoveStraight(1.0, 1.0))
        val triangle = Triangle(point1, point2, point3)
        triangle.move()
        assertEquals(1.0, triangle.point1.x)
        assertEquals(1.0, triangle.point1.y)
        assertEquals(4.0, triangle.point2.x)
        assertEquals(1.0, triangle.point2.y)
        assertEquals(2.5, triangle.point3.x)
        assertEquals(3.0, triangle.point3.y)
    }
    
    @Test
    fun testMoveTriangleWithNegativeDelta() {
        val point1 = Point(0.0, 0.0, MoveStraight(-1.0, -1.0))
        val point2 = Point(3.0, 0.0, MoveStraight(-1.0, -1.0))
        val point3 = Point(1.5, 2.0, MoveStraight(-1.0, -1.0))
        val triangle = Triangle(point1, point2, point3)
        triangle.move()
        assertEquals(-1.0, triangle.point1.x)
        assertEquals(-1.0, triangle.point1.y)
        assertEquals(2.0, triangle.point2.x)
        assertEquals(-1.0, triangle.point2.y)
        assertEquals(0.5, triangle.point3.x)
        assertEquals(1.0, triangle.point3.y)
    }

    @Test
    fun testSetMoveStrategyTriangle() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(3.0, 0.0, null)
        val point3 = Point(1.5, 2.0, null)
        val triangle = Triangle(point1, point2, point3)
        triangle.setMoveStrategy(MoveStraight(1.0, 1.0))
        triangle.move()
        assertEquals(1.0, triangle.point1.x)
        assertEquals(1.0, triangle.point1.y)
        assertEquals(4.0, triangle.point2.x)
        assertEquals(1.0, triangle.point2.y)
        assertEquals(2.5, triangle.point3.x)
        assertEquals(3.0, triangle.point3.y)
    }
    

}