package web.lab3.server.utils;

public class PointChecker {
    public static boolean isPointInsideArea(double x, double y, double r){
        return isPointInsideCircle(x, y, r) || isPointInsideRectangle(x, y, r) || isPointInsideTriangle(x, y, r);
    }

    private static boolean isPointInsideTriangle(double x, double y, double r){
        boolean isXInRange = (x >= 0 ) && (x <= r);
        boolean isYInRange = (y <= 0) && (y >= -r);
        boolean isFormula = y>(x-r);
        return isXInRange && isYInRange && isFormula;
    }

    private static boolean isPointInsideRectangle(double x, double y, double r){
        boolean isXInRange = (x >= 0) && (x <= r);
        boolean isYInRange = (y >= 0) && (y <= r/2);
        return isXInRange && isYInRange;
    }

    private static boolean isPointInsideCircle(double x, double y, double r){
        boolean isXInRange = (x <= 0) && (x >= (-r));
        boolean isYInRange = (y <= 0) && (y >= (-r));
        boolean isFormula = (x*x + y*y) <= (r*r);
        return isXInRange && isYInRange && isFormula;
    }
}
