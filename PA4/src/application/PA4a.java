package application;

import java.util.ArrayList;
import java.util.Scanner;

public class PA4a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the encrypted message: ");
        String encrypted = scanner.nextLine();

        System.out.print("Enter the substring to search for: ");
        String substring = scanner.nextLine();

        // Check if inputs are empty
        if (encrypted.isEmpty() || substring.isEmpty()) {
            System.out.println("Please supply correct inputs: <encrypted string> <substring>");
            scanner.close();
            return;
        }

        // Create Shifter instance
        Shifter shifter = new Shifter(encrypted);

        // Find shifts containing the substring
        ArrayList<String> results = shifter.findShiftsContaining(substring);

        // Output results
        if (results.isEmpty()) {
            System.out.println("No valid shifts found.");
        } else {
            for (String result : results) {
                System.out.println(result);
            }
        }

        scanner.close();
    }
}

