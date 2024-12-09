package array;

public class SpecialArrayII {
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pre = new int[n];
        for(int i=1;i<n;i++) {
            pre[i] = pre[i-1];
            if((nums[i]&1)==(nums[i-1]&1)){
                pre[i]++;
            }
        }


        int q = queries.length;
        boolean[] res = new boolean[q];

        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(pre[r]-pre[l]==0) res[i] = true;
            else res[i] = false;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
