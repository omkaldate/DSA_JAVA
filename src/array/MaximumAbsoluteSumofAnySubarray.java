package array;

public class MaximumAbsoluteSumofAnySubarray {
    public static int maxAbsoluteSum(int[] arr) {

        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<arr.length; i++){
            sum += arr[i];

            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;
        }


        sum = 0;
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(sum > arr[i]) sum = arr[i];
            if(sum < mini) mini = sum;
        }
        return Math.max(Math.abs(mini), Math.abs(maxi));
    }


    public static void main(String[] args) {

    }
}
