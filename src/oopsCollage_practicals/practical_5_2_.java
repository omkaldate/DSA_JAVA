package oopsCollage_practicals;

import java.util.Arrays;
public class practical_5_2_ {
    public static void main(String[] args) {
        System.out.println("Name :  Om Balasaheb Kaldate");
        String[] names = {"ram", "om", "shiv", "Diana", "krishna"}; // List of names to sort

        System.out.println("Original list of names: " + Arrays.toString(names));

        Arrays.sort(names); // Sorting the array of names

        System.out.println("Sorted list of names: " + Arrays.toString(names));
    }
}
