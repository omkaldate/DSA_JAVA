package array;

import java.util.Arrays;

public class minimunNumbersOfMovesToSeatEveryone {
    public static int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        int sum =0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i=0; i<n; i++){
            sum += Math.abs(seats[i]-students[i]);
        }
        return sum;
    }

    public static void main(String[] args){
        int []seats = {3,1,5};
        int[]students = {2,7,4};
        System.out.println(minMovesToSeat(seats,students));
    }
}
