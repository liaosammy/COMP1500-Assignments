package application;

import java.util.Arrays;

public class Triangle extends Shape2D {
    private Point2D[] vertices;

    public Triangle(Point2D v1, Point2D v2, Point2D v3) {
        vertices = new Point2D[] { v1, v2, v3 };
    }

    @Override
    public double getArea() {
        double x1 = vertices[0].getX(), y1 = vertices[0].getY();
        double x2 = vertices[1].getX(), y2 = vertices[1].getY();
        double x3 = vertices[2].getX(), y3 = vertices[2].getY();
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    @Override
    public double getPerimeter() {
        double a = distance(vertices[0], vertices[1]);
        double b = distance(vertices[1], vertices[2]);
        double c = distance(vertices[2], vertices[0]);
        return a + b + c;
    }

    private double distance(Point2D p1, Point2D p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    @Override
    public Point2D getCenter() {
        double x = (vertices[0].getX() + vertices[1].getX() + vertices[2].getX()) / 3;
        double y = (vertices[0].getY() + vertices[1].getY() + vertices[2].getY()) / 3;
        return new Point2D(x, y);
    }

    @Override
    public Point2D[] getVertices() {
        return vertices;
    }

    public Point2D[] getAABB() {
        double minX = Arrays.stream(vertices).mapToDouble(Point2D::getX).min().orElse(0);
        double maxX = Arrays.stream(vertices).mapToDouble(Point2D::getX).max().orElse(0);
        double minY = Arrays.stream(vertices).mapToDouble(Point2D::getY).min().orElse(0);
        double maxY = Arrays.stream(vertices).mapToDouble(Point2D::getY).max().orElse(0);

        return new Point2D[] {
            new Point2D(minX, minY),
            new Point2D(minX, maxY),
            new Point2D(maxX, maxY),
            new Point2D(maxX, minY)
        };
    }
}

