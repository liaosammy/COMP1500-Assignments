package application;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class PA5b {

    // Method to match the pattern with the haystack
    public static String[] patternMatch(String pattern, String haystack) {
        List<String> matches = new ArrayList<>();
        int patternLength = pattern.length();
        int haystackLength = haystack.length();

        // Iterate over each possible starting position in the haystack
        for (int i = 0; i <= haystackLength - patternLength; i++) {
            String substring = haystack.substring(i, i + patternLength);
            if (matchesPattern(pattern, substring)) {
                matches.add(substring);
            }
        }

        // Convert List to Array
        return matches.toArray(new String[0]);
    }

    // Method to check if the substring matches the pattern
    private static boolean matchesPattern(String pattern, String substring) {
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            char substringChar = substring.charAt(i);
            // Check if the pattern character is a dash or matches the substring character
            if (patternChar != '-' && patternChar != substringChar) {
                return false;
            }
        }
        return true;
    }

    // Example usage method
    public static void main(String[] args) {
        // Example usage
        printMatches(patternMatch("A--G-", "ACTGGTACTGA")); // ["ACTGG", "ACTGA"]
        printMatches(patternMatch("-GG-", "ACTGGTACTGA")); // ["TGGT"]
        printMatches(patternMatch("-GGC", "ACTGGTACTGA")); // []
    }

    // Utility method to print matches
    private static void printMatches(String[] matches) {
        if (matches.length == 0) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matches: ");
            for (String match : matches) {
                System.out.println(match);
            }
        }
    }
}

