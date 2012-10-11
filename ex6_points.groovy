class Point {
    private double x, y
    
    Point(double new_x, double new_y) { moveTo(new_x, new_y) }
    Point(Point old_point) { moveTo(old_point) }
    double getX() { return x }
    double getY() { return y }
    
    double distanceTo(Point other) {
        return distanceTo(other.getX(), other.getY())
    }
    
    double distanceTo(double to_x, double to_y) {
        return ( (x-to_x)**2 + (y-to_y)**2 )**0.5
    }
    
    double distanceToOrigin() {
        return distanceTo(0,0)
    }
    
    void moveTo(double to_x, double to_y) {
        x = to_x
        y = to_y
    }
    
    void moveTo(Point other) {
        x = other.getX()
        y = other.getY()
    }
    
    Point clone() {
        return new Point(this)
    }
    
    void scale(double factor) {
        x *= factor
        y *= factor
    }
    
    Point opposite() {
        Point new_point = clone()
        new_point.scale(-1)
        return new_point
    }
    
    void print() {
        println x + ", " + y
    }
}

