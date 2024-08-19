package application;

public class Point2D {
    private double x;
    private double y;

    // No-argument constructor sets the point to the origin (0,0)
    public Point2D() {
        this(0, 0);
    }

    // Constructor with parameters
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x
    public double getX() {
        return x;
    }

    // Getter for y
    public double getY() {
        return y;
    }

    // toString method to return (x, y) format with three decimal places
    @Override
    public String toString() {
        return String.format("(%.3f, %.3f)", x, y);
    }

    // Static method to calculate the Euclidean distance between two points
    public static double distance(Point2D p1, Point2D p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Instance method to calculate the distance from this point to another point
    public double distance(Point2D other) {
        return Point2D.distance(this, other);
    }
}

