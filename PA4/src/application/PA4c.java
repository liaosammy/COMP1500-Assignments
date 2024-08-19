package application;

import java.util.ArrayList;
import java.util.Scanner;

public class PA4c {

    // Method to remove duplicates from the ArrayList
    public static void removeRepeated(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            int current = list.get(i);
            int j = i + 1;
            while (j < list.size()) {
                if (list.get(j) == current) {
                    list.remove(j);
                } else {
                    j++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (press Enter and then CTRL+D to finish):");
        
        // Read integers from the console
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        // Remove duplicates
        removeRepeated(numbers);

        // Output the distinct integers
        if (numbers.isEmpty()) {
            System.out.println("No values entered.");
        } else {
            System.out.print("The distinct integer(s): ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
