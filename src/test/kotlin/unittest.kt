import org.example.Point
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import MoveStraight
import kotlin.test.assertEquals

class TestPoint {
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
}