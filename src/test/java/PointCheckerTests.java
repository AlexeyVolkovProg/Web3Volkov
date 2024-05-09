import org.junit.Test;
import web.lab3.server.utils.PointChecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PointCheckerTests {
    @Test
    public void testPointInsideCircle() {
        assertTrue(PointChecker.isPointInsideArea(-0.5, -0.5, 1));
        assertFalse(PointChecker.isPointInsideArea(1, 1, 1));
        assertFalse(PointChecker.isPointInsideArea(2, 2, 1));
    }

    @Test
    public void testPointInsideRectangle() {
        assertTrue(PointChecker.isPointInsideArea(0.5, 0.25, 1));
        assertTrue(PointChecker.isPointInsideArea(0, 0, 1));
        assertFalse(PointChecker.isPointInsideArea(1, 2, 1));
        assertFalse(PointChecker.isPointInsideArea(0, 1, 1));
    }

    @Test
    public void testPointInsideTriangle() {
        assertTrue(PointChecker.isPointInsideArea(0.5, 0.5, 1));
        assertTrue(PointChecker.isPointInsideArea(0, -1, 1));
        assertFalse(PointChecker.isPointInsideArea(1, 1, 1));
        assertFalse(PointChecker.isPointInsideArea(-2, -1, 1));
    }

    @Test
    public void testPointOutsideAllAreas() {
        assertFalse(PointChecker.isPointInsideArea(2, 2, 1));
        assertFalse(PointChecker.isPointInsideArea(-2, -2, 1));
        assertFalse(PointChecker.isPointInsideArea(2, -2, 1));
        assertFalse(PointChecker.isPointInsideArea(-2, 2, 1));
    }
}
