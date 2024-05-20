package bitMasking;

public class SumOfAllSubsetXORTotals {
    public static void main(String[] args){
        int[]nums = {1,3};

        int n=nums.length;
        int result =0;
        for(int i: nums){
            result |= i;
        }
        System.out.println(result<< n-1);
    }
}
