package ATest;

import java.util.Scanner;

public class ConsecutiveSymbolCounter {

    public static void main(String[] args) {
        // Read the input from standard input
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();

        // Initialize result to store the concatenated count of consecutive symbols
        StringBuilder result = new StringBuilder();

        // Variables to track current symbol and count of consecutive occurrences
        char currentSymbol = inputStr.charAt(0);
        int count = 1;

        // Iterate through the input string starting from the second character
        for (int i = 1; i < inputStr.length(); i++) {
            char symbol = inputStr.charAt(i);

            // If the symbol is the same as the current symbol, increment the count
            if (symbol == currentSymbol) {
                count++;
            } else {
                // Append the count of the previous symbol to result and reset for the new symbol
                result.append(count);
                currentSymbol = symbol;
                count = 1;  // Reset count for the new symbol
            }
        }

        // Append the count for the last group of symbols
        result.append(count);

        // Print the result with a trailing newline
        System.out.println(result);
    }
}
