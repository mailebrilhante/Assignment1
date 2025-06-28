import org.example.Point
import org.junit.jupiter.api.Test
import MoveStraight
import kotlin.test.assertEquals

class TestPoint {
    @Test
    fun testMove() {
        val point = Point(0.0, 0.0, MoveStraight(1.0, 1.0))
        val newPoint = point.move()
        assertEquals(1.0, newPoint.x)
        assertEquals(1.0, newPoint.y)
    }
}