package oopsCollage_practicals;
import java.util.Arrays;
import java.util.Scanner;

public class takingInputFromUser {
    public static void main(String[] rgs ){

        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[5];

        for(int i=0; i<arr.length; i++){
            System.out.println("enter " + i + " st name : ");
            arr[i] = scanner.next();
        }

     System.out.println(Arrays.toString(arr));

    }
}
