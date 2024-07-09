package array;

public class AverageWaitingTime {
    public static  double averageWaitingTime(int[][] customers) {
        double totalTime = 0;
        double chefTime = 0;
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int orderTime = customer[1];
            chefTime = Math.max(chefTime, arrivalTime) + orderTime;
            totalTime += chefTime - arrivalTime;
        }
        return  (double)totalTime / customers.length;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {1,2},
                {2,5},
                {4,3}
        };
        System.out.println(averageWaitingTime(arr));
    }
}
