package HardProblems;

import java.util.HashMap;

public class IntegerToEnglishWord {

    private static String solve(int num, HashMap<Integer, String> belowTen, HashMap<Integer, String> belowTwenty, HashMap<Integer, String> belowHundred) {
        if (num < 10) {
            return belowTen.get(num);
        }
        if (num < 20) {
            return belowTwenty.get(num);
        }
        if (num < 100) {
            return belowHundred.get(num / 10) + ((num % 10 != 0) ? " " + belowTen.get(num % 10) : "");
        }
        if (num < 1000) {
            return belowTen.get(num / 100) + " Hundred" + ((num % 100 != 0) ? " " + solve(num % 100, belowTen, belowTwenty, belowHundred) : "");
        }
        if (num < 1000000) {
            return solve(num / 1000, belowTen, belowTwenty, belowHundred) + " Thousand" + ((num % 1000 != 0) ? " " + solve(num % 1000, belowTen, belowTwenty, belowHundred) : "");
        }
        if (num < 1000000000) {
            return solve(num / 1000000, belowTen, belowTwenty, belowHundred) + " Million" + ((num % 1000000 != 0) ? " " + solve(num % 1000000, belowTen, belowTwenty, belowHundred) : "");
        }
        return solve(num / 1000000000, belowTen, belowTwenty, belowHundred) + " Billion" + ((num % 1000000000 != 0) ? " " + solve(num % 1000000000, belowTen, belowTwenty, belowHundred) : "");
    }

    private static void fill(HashMap<Integer, String> belowTen, HashMap<Integer, String> belowTwenty, HashMap<Integer, String> belowHundred) {
        belowTen.put(0, "");
        belowTen.put(1, "One");
        belowTen.put(2, "Two");
        belowTen.put(3, "Three");
        belowTen.put(4, "Four");
        belowTen.put(5, "Five");
        belowTen.put(6, "Six");
        belowTen.put(7, "Seven");
        belowTen.put(8, "Eight");
        belowTen.put(9, "Nine");

        belowTwenty.put(10, "Ten");
        belowTwenty.put(11, "Eleven");
        belowTwenty.put(12, "Twelve");
        belowTwenty.put(13, "Thirteen");
        belowTwenty.put(14, "Fourteen");
        belowTwenty.put(15, "Fifteen");
        belowTwenty.put(16, "Sixteen");
        belowTwenty.put(17, "Seventeen");
        belowTwenty.put(18, "Eighteen");
        belowTwenty.put(19, "Nineteen");

        belowHundred.put(2, "Twenty");
        belowHundred.put(3, "Thirty");
        belowHundred.put(4, "Forty");
        belowHundred.put(5, "Fifty");
        belowHundred.put(6, "Sixty");
        belowHundred.put(7, "Seventy");
        belowHundred.put(8, "Eighty");
        belowHundred.put(9, "Ninety");
    }

    public static String numberToWords(int num) {
        HashMap<Integer, String> belowTen = new HashMap<>();
        HashMap<Integer, String> belowTwenty = new HashMap<>();
        HashMap<Integer, String> belowHundred = new HashMap<>();
        fill(belowTen, belowTwenty, belowHundred);

        if (num == 0) return "Zero";
        return solve(num, belowTen, belowTwenty, belowHundred);
    }


    public static void main(String[] args) {
        System.out.println(numberToWords(3456));
    }
}
