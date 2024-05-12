package recursion;

public class takingMaximumEnergyFromtheMysticDungeon {
    public static int helper(int[]arr, int ind, int k, int ans) {
        if(ind > arr.length - 1) {
            return ans;
        }
        int sum = 0;
         sum += helper(arr, ind+k, k, ans+arr[ind]);
        return sum;
    }


    public static void main(String[] args){
        int[] energy = {5,2,-10,-5,1};
        int k=3;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < energy.length; i++) {
            ans = Math.max(ans, helper(energy, i, k, 0));
        }
        System.out.println(ans);
    }
}
