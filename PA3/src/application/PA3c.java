package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PA3c {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x, y;

        try {
            // Prompt user for input
            System.out.print("Enter the x-coordinate: ");
            x = scanner.nextDouble();
            System.out.print("Enter the y-coordinate: ");
            y = scanner.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.close();
            return;
        }

        // Create Point2D instances
        Point2D origin = new Point2D();
        Point2D point2 = new Point2D(x, y);

        // Calculate distances
        double staticDistance = Point2D.distance(origin, point2);
        double distanceFromP1 = origin.distance(point2);
        double distanceFromP2 = point2.distance(origin);

        // Print results
        System.out.println("Point 1: " + origin);
        System.out.println("Point 2: " + point2);
        System.out.printf("Static method distance: %.3f%n", staticDistance);
        System.out.printf("Distance from P1: %.3f%n", distanceFromP1);
        System.out.printf("Distance from P2: %.3f%n", distanceFromP2);

        scanner.close();
    }
}


