package application;

public class Rectangle extends Shape2D {
    private Point2D lowerLeft;
    private Point2D upperRight;

    public Rectangle(Point2D lowerLeft, Point2D upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    @Override
    public double getArea() {
        double width = upperRight.getX() - lowerLeft.getX();
        double height = upperRight.getY() - lowerLeft.getY();
        return width * height;
    }

    @Override
    public double getPerimeter() {
        double width = upperRight.getX() - lowerLeft.getX();
        double height = upperRight.getY() - lowerLeft.getY();
        return 2 * (width + height);
    }

    @Override
    public Point2D getCenter() {
        double x = (lowerLeft.getX() + upperRight.getX()) / 2;
        double y = (lowerLeft.getY() + upperRight.getY()) / 2;
        return new Point2D(x, y);
    }

    @Override
    public Point2D[] getVertices() {
        Point2D upperLeft = new Point2D(lowerLeft.getX(), upperRight.getY());
        Point2D lowerRight = new Point2D(upperRight.getX(), lowerLeft.getY());
        return new Point2D[] { lowerLeft, upperLeft, upperRight, lowerRight };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return lowerLeft.equals(rectangle.lowerLeft) && upperRight.equals(rectangle.upperRight);
    }

    @Override
    public int hashCode() {
        return lowerLeft.hashCode() + upperRight.hashCode();
    }
}

