package application;

import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the first phrase
        System.out.print("Enter phrase 1: ");
        String phrase1 = scanner.nextLine();

        // Prompt user for the second phrase
        System.out.print("Enter phrase 2: ");
        String phrase2 = scanner.nextLine();

        // Check if the phrases are anagrams and print the result
        if (!(isOnlyAlphabetic(phrase1)) || !(isOnlyAlphabetic(phrase2))) {
        	System.out.println("Phrase(s) must be in the form of letters");
        } else if (areAnagrams(phrase1, phrase2)) {
            System.out.println("These phrases are anagrams.");
        } else {
            System.out.println("These phrases are not anagrams.");
        }

        scanner.close();
    }

    // Method to check if two phrases are anagrams
    public static boolean areAnagrams(String phrase1, String phrase2) {
        int[] letterCounts1 = countLetters(phrase1);
        int[] letterCounts2 = countLetters(phrase2);

        return sameCounts(letterCounts1, letterCounts2);
    }

    // Method to count the occurrence of each letter in a phrase
    public static int[] countLetters(String phrase) {
        int[] counts = new int[26]; // Array to hold counts of a-z

        // Convert the phrase to lowercase and iterate through each character
        phrase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            // Only consider letters a-z
            if (ch >= 'a' && ch <= 'z') {
                counts[ch - 'a']++;
            }
        }
        return counts;
    }

    // Method to compare if two arrays have the same counts
    public static boolean sameCounts(int[] counts1, int[] counts2) {
        // Check if both arrays have the same length
        if (counts1.length != counts2.length) {
            return false;
        }

        // Compare each element in the arrays
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }
        return true; 
    }
    
    public static boolean isOnlyAlphabetic(String input) {
        return input.matches("[a-zA-Z ]+");  // Allow alphabetic characters and spaces
    }
}
