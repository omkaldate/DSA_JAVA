package slidingWindow;

public class longestSubArrayOfSumK {
    public static void main(String[] args){
        int[]arr = {4,2,1,1,1,2,3,5};
        int k =5;
        System.out.println(lorgest(arr , k));
    }
    public static int lorgest(int[]arr , int k){
        int n= arr.length;
        int sum =0;
        int maxi =0;
        int i=0,j=0;

        while(j<n){
            sum = sum+arr[j];
            if(sum<k){
                j++;
            }
            else if(sum == k){
                maxi = Math.max(maxi , j-i+1);
                j++;
            }
            if(sum >k){
                while(sum > k){
                    sum = sum-arr[i];
                    i++;
                }
                j++;
            }

        }
        return maxi;
    }
}
