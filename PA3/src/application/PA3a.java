package application;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class PA3a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Please enter the strings to analyze, separated by spaces:");
        String inputLine = scanner.nextLine();

        // Split the input line into arguments
        String[] arguments = inputLine.split("\\s+");

        if (arguments.length == 0) {
            System.out.println("Please supply at least one argument.");
            return;
        }

        int totalArguments = arguments.length;
        boolean hasDuplication = hasDuplicates(arguments);

        System.out.printf("Arguments (%d, %s): %s%n", totalArguments, hasDuplication ? "has duplication" : "no duplication", String.join(" ", arguments));

        LengthStats stats = lengthStats(arguments);
        System.out.printf("Length: total=%d, avg=%d%n", stats.totalLength, stats.averageLength);

        String shortest = findElementOfLength(arguments, stats.minLength, true);
        String longest = findElementOfLength(arguments, stats.maxLength, true);
        String average = findElementOfLength(arguments, stats.averageLength, false);

        System.out.printf("Shortest (%d): first=<%s>, last=<%s>%n", stats.minLength, shortest, findElementOfLength(arguments, stats.minLength, false));
        System.out.printf("Longest (%d): first=<%s>, last=<%s>%n", stats.maxLength, longest, findElementOfLength(arguments, stats.maxLength, false));
        System.out.printf("Average (%d): %s%n", stats.averageLength, average != null ? "<" + average + ">" : "none");
    }

    public static boolean hasDuplicates(String[] args) {
        Set<String> seen = new HashSet<>();
        for (String arg : args) {
            if (!seen.add(arg)) {
                return true;
            }
        }
        return false;
    }

    public static int averageLength(String[] args) {
        if (args.length == 0) {
            return 0;
        }

        int totalLength = 0;
        for (String arg : args) {
            totalLength += arg.length();
        }

        return (int) Math.round((double) totalLength / args.length);
    }

    public static LengthStats lengthStats(String[] args) {
        LengthStats stats = new LengthStats();
        if (args.length == 0) {
            return stats;
        }

        int totalLength = 0;
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (String arg : args) {
            int length = arg.length();
            totalLength += length;
            if (length < minLength) minLength = length;
            if (length > maxLength) maxLength = length;
        }

        stats.totalLength = totalLength;
        stats.averageLength = averageLength(args);
        stats.minLength = minLength;
        stats.maxLength = maxLength;

        return stats;
    }

    public static String findElementOfLength(String[] args, int length, boolean findFirst) {
        if (findFirst) {
            for (String arg : args) {
                if (arg.length() == length) {
                    return arg;
                }
            }
        } else {
            for (int i = args.length - 1; i >= 0; i--) {
                if (args[i].length() == length) {
                    return args[i];
                }
            }
        }
        return null;
    }

    private static class LengthStats {
        int totalLength;
        int averageLength;
        int minLength;
        int maxLength;
    }
}

