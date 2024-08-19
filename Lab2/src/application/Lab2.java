package application;

public class Lab2 {
    
    // Converts a letter to its corresponding phone keypad number
    public static int letterToPhone(char letter) {
        switch (letter) {
            case 'A': case 'B': case 'C': return 2;
            case 'D': case 'E': case 'F': return 3;
            case 'G': case 'H': case 'I': return 4;
            case 'J': case 'K': case 'L': return 5;
            case 'M': case 'N': case 'O': return 6;
            case 'P': case 'Q': case 'R': case 'S': return 7;
            case 'T': case 'U': case 'V': return 8;
            case 'W': case 'X': case 'Y': case 'Z': return 9;
            default: throw new IllegalArgumentException("Invalid letter: " + letter);
        }
    }

    // Computes the response based on the challenge and the PIN
    public static String getResponse(String challenge, String pin) {
        StringBuilder response = new StringBuilder();

        for (int i = 0; i < pin.length(); i++) {
            int pinDigit = letterToPhone(pin.charAt(i));  // Convert PIN letter to corresponding number
            response.append(challenge.charAt(pinDigit));  // Use this number as an index in the challenge
        }

        return response.toString();
    }

    // Checks if the input string is of a specified length
    public static boolean stringIsKDigits(String str, int length) {
        return str.length() == length;
    }

    // Checks if the input string consists of all digits
    public static boolean allDigits(String str) {
        return str.matches("\\d+");
    }

    // Checks if the input string consists of all uppercase letters
    public static boolean allUppercaseLetters(String str) {
        return str.matches("[A-Z]+");
    }

    // Converts a digit string to an integer array
    public static int[] digitStringToIntArray(String str) {
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }

    // Main method to run the program
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Prompt for the challenge sequence
        System.out.print("Enter value sequence: ");
        String challenge = scanner.nextLine();

        // Validate the challenge sequence
        if (!stringIsKDigits(challenge, 10) || !allDigits(challenge)) {
            System.out.println("Invalid sequence");
            return;
        }

        // Prompt for the PIN
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Validate the PIN
        if (!allUppercaseLetters(pin)) {
            System.out.println("Invalid PIN");
            return;
        }

        // Compute and display the response
        String response = getResponse(challenge, pin);
        System.out.println("Response: " + response);
    }
}