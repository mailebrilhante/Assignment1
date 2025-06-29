import org.example.Point
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import MoveStraight
import kotlin.test.assertEquals

class TestAssignment1 {
   
    // ======Tests for Point Class =====
    @Test
    fun testMove() {
        val point = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        point.movePoint()
        assertEquals(1.0, point.x)
        assertEquals(1.0, point.y)
    }

    @Test
    fun testSetMoveStrategy() {
        val point = Point(0.0, 0.0, null)
        point.setMoveStrategy(MoveStraight(1.0, 1.0))
        point.movePoint()
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
        val point2 = Point(1.0, 1.0, null)
        val line = Line(point1, point2)
        assertEquals(Math.sqrt(2.0), line.getLength())
    }

    @Test
    fun testGetSlope() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(1.0, 1.0, null)
        val line = Line(point1, point2)
        assertEquals(1.0, line.getSlope())
    }

    @Test
    fun testMoveLine(){
        val point1 = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val point2 = Point(1.0, 1.0, MoveStraight(1.0, 1.0))
        val line = Line(point1, point2)
        line.moveLine()
        assertEquals(1.0, line.start.x)
        assertEquals(1.0, line.start.y)
        assertEquals(2.0, line.end.x)
        assertEquals(2.0, line.end.y)
    }

    @Test
    fun testSetMoveStrategyLine() {
        val point1 = Point(0.0, 0.0, null)
        val point2 = Point(1.0, 1.0, null)
        val line = Line(point1, point2)
        line.setMoveStrategy(MoveStraight(1.0, 1.0))
        line.moveLine()
        assertEquals(1.0, line.start.x)
        assertEquals(1.0, line.start.y)
        assertEquals(2.0, line.end.x)
        assertEquals(2.0, line.end.y)
    }

    // ======Tests for Rectangle Class =====

@Test
    fun testRectangleCreation() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 2.0, null)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertEquals(0.0, rectangle.topLeft.x)
        assertEquals(0.0, rectangle.topLeft.y)
        assertEquals(2.0, rectangle.bottomRight.x)
        assertEquals(2.0, rectangle.bottomRight.y)
    }

    @Test
    fun testInvalidRectangle() {
        val topLeft = Point(1.0, 1.0, null)
        val bottomRight = Point(1.0, 1.0, null)
        assertThrows<IllegalArgumentException> {
            Rectangle(topLeft, bottomRight)
        }
    }

    @Test
    fun testGetRectangleArea() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 3.0, null)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertEquals(6.0, rectangle.getArea())
    }

    @Test
    fun testGetRectangleAttributes() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 3.0, null)
        val rectangle = Rectangle(topLeft, bottomRight)
        val attributes = rectangle.getAttributes()
        assertEquals("Top Left: (0.0, 0.0)", attributes[0])
        assertEquals("Bottom Right: (2.0, 3.0)", attributes[1])
    }
    @Test
    fun testMoveRectangle() {
        val topLeft = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val bottomRight = Point(2.0, 2.0, MoveStraight(1.0, 1.0))
        val rectangle = Rectangle(topLeft, bottomRight)
        rectangle.moveShape()
        assertEquals(1.0, rectangle.topLeft.x)
        assertEquals(1.0, rectangle.topLeft.y)
        assertEquals(3.0, rectangle.bottomRight.x)
        assertEquals(3.0, rectangle.bottomRight.y)
    }

    // ===== Test for Square Class =====
    @Test
    fun testSquareCreation() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 2.0, null)
        val square = Square(topLeft, bottomRight)
        assertEquals(0.0, square.topLeft.x)
        assertEquals(0.0, square.topLeft.y)
        assertEquals(2.0, square.bottomRight.x)
        assertEquals(2.0, square.bottomRight.y)
    }
    @Test   
    fun testInvalidSquare() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 3.0, null)
        assertThrows<IllegalArgumentException> {
            Square(topLeft, bottomRight)
        }
    }
    @Test
    fun testMoveSquare() {
        val topLeft = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val bottomRight = Point(2.0, 2.0, MoveStraight(1.0, 1.0))
        val square = Square(topLeft, bottomRight)
        square.moveShape()
        assertEquals(1.0, square.topLeft.x)
        assertEquals(1.0, square.topLeft.y)
        assertEquals(3.0, square.bottomRight.x)
        assertEquals(3.0, square.bottomRight.y)
    }
    @Test
    fun testGetSquareArea() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 2.0, null)
        val square = Square(topLeft, bottomRight)
        assertEquals(4.0, square.getArea())
    }
    @Test
    fun testGetSquareAttributes() {
        val topLeft = Point(0.0, 0.0, null)
        val bottomRight = Point(2.0, 2.0, null)
        val square = Square(topLeft, bottomRight)
        val attributes = square.getAttributes()
        assertEquals("Top Left: (0.0, 0.0)", attributes[0])
        assertEquals("Bottom Right: (2.0, 2.0)", attributes[1])
    }

    // ======Tests for Ellipse Class =====
    @Test
    fun testEllipseCreation() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        assertEquals(center, ellipse.center)
        assertEquals(radius1, ellipse.radius1)
        assertEquals(radius2, ellipse.radius2)
    }
    @Test
    fun testInvalidEllipse() {
        val center = Point(0.0, 0.0, null)
        val radius1 = -1.0
        val radius2 = 2.0
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

    fun testGetEllipseAttributes() {
        val center = Point(0.0, 0.0, null)
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        val attributes = ellipse.getAttributes()
        assertEquals(center, attributes[0])
        assertEquals(radius1, attributes[1])
        assertEquals(radius2, attributes[2])
    }
    @Test
    fun testMoveEllipse() {
        val center = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val radius1 = 3.0
        val radius2 = 2.0
        val ellipse = Ellipse(center, radius1, radius2)
        ellipse.moveShape()
        assertEquals(1.0, ellipse.center.x)
        assertEquals(1.0, ellipse.center.y)
    }
    

}