package application;

import java.util.ArrayList;

public class Shifter {
    private String encrypted;

    // Constructor
    public Shifter(String encrypted) {
        this.encrypted = encrypted;
    }

    // Method to shift the string by a specified amount
    public String shift(int amount) {
        StringBuilder shifted = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    shifted.append((char) ('A' + (c - 'A' + amount) % 26));
                } else {
                    shifted.append((char) ('a' + (c - 'a' + amount) % 26));
                }
            } else {
                shifted.append(c);
            }
        }
        return shifted.toString();
    }

    // Method to find all shifts containing the substring
    public ArrayList<String> findShiftsContaining(String substring) {
        ArrayList<String> results = new ArrayList<>();
        for (int shift = 0; shift < 26; shift++) {
            String shiftedText = shift(shift);
            if (shiftedText.contains(substring)) {
                results.add(String.format("%02d: %s", shift, shiftedText));
            }
        }
        return results;
    }
}

