package slidingWindow;

public class maxSumSubarrayofsizeK {
    public static void main(String[] args){
        int[] arr={2,5,1,8,2,9};
        int k=3;
        System.out.println(funk(arr , k));
    }


    public static int funk(int[]arr , int k){
        int n=arr.length;
        int i=0,j=0;
        int sum=0 , maxSum=0;

        while(j<n){
            sum += arr[j];
            if(j-i+1 == k){
                maxSum = Math.max(maxSum , sum);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
