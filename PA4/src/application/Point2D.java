package application;

public class Point2D {
    private double x;
    private double y;

    // Constructor
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // No-arg constructor for default origin point
    public Point2D() {
        this(0, 0);
    }

    // Getter methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Check if points are equal within a distance threshold
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point2D point = (Point2D) obj;
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2)) < 1e-6;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) + Double.hashCode(y);
    }

    @Override
    public String toString() {
        return String.format("(%.3f, %.3f)", x, y);
    }
}

