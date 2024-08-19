package application;

import java.util.Scanner;

public class PA4b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the color:");
        String color = scanner.nextLine();

        System.out.println("Please enter the x1 coordinate:");
        double x1 = readDouble(scanner);

        System.out.println("Please enter the y1 coordinate:");
        double y1 = readDouble(scanner);

        System.out.println("Please enter the x2 coordinate:");
        double x2 = readDouble(scanner);

        System.out.println("Please enter the y2 coordinate:");
        double y2 = readDouble(scanner);

        System.out.println("Please enter the x3 coordinate:");
        double x3 = readDouble(scanner);

        System.out.println("Please enter the y3 coordinate:");
        double y3 = readDouble(scanner);

        scanner.close();

        Point2D p1 = new Point2D(x1, y1);
        Point2D p2 = new Point2D(x2, y2);
        Point2D p3 = new Point2D(x3, y3);
        Triangle triangle = new Triangle(p1, p2, p3);

        String csv = shapeVertices(triangle, color);
        System.out.println(csv);
    }

    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    public static String shapeVertices(Shape2D shape, String color) {
        StringBuilder csv = new StringBuilder();

        if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            for (Point2D vertex : triangle.getVertices()) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
            Point2D[] aabb = triangle.getAABB();
            for (Point2D vertex : aabb) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            for (Point2D vertex : rectangle.getVertices()) {
                csv.append(String.format("\"%s\",%.3f,%.3f%n", color, vertex.getX(), vertex.getY()));
            }
        }

        return csv.toString();
    }
}


  


