package array;

public class NumberofSubarraysWithOddSum {


    public static int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int even = 1;
        int odd = 0;
        int ans = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum %2 == 1){
                ans += even;
                odd++;
            }
            else{
                ans += odd;
                even++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr = {1,3,5};
        System.out.println(numOfSubarrays(arr));
    }
}
