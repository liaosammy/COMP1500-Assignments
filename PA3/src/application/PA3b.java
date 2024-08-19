package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PA3b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b, c, d, e, f;

        try {
            // Prompt user for input
            System.out.print("Enter the coefficients a, b, c, d, e, f for the equations:\n");
            System.out.print("a: ");
            a = scanner.nextDouble();
            System.out.print("b: ");
            b = scanner.nextDouble();
            System.out.print("c: ");
            c = scanner.nextDouble();
            System.out.print("d: ");
            d = scanner.nextDouble();
            System.out.print("e: ");
            e = scanner.nextDouble();
            System.out.print("f: ");
            f = scanner.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter valid numbers.");
            return;
        }

        // Create LinearEquation instance
        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

        // Check if the system is solvable and print the result
        if (!equation.isSolvable()) {
            System.out.println("The equation has no solution.");
        } else {
            double x = equation.getX();
            double y = equation.getY();
            System.out.printf("Solution: x=%.3f, y=%.3f%n", x, y);
        }

        scanner.close();
    }
}








