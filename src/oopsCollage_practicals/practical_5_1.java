package oopsCollage_practicals;

import java.util.Arrays;
public class practical_5_1 {
    public static void main(String[] args) {
        System.out.println("Name : Om Balasaheb Kaldate");
        int[] numbers = {7,6,8,5,4,3,2,1,0,19,88}; // List of integers to sort

        System.out.println("Original list of integers: " + Arrays.toString(numbers));

        Arrays.sort(numbers); // Sorting the array of integers

        System.out.println("Sorted list of integers: " + Arrays.toString(numbers));
    }
}
