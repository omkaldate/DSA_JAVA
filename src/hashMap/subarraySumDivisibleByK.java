package hashMap;

import java.util.HashMap;
import java.util.Map;

public class subarraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int sum =0;
        System.out.println(sum);
        int cnt =0;

        for(int i=0; i<n; i++){
            sum += nums[i];
            int res = sum%k;

            if(res<0){
                res += k;
            }
            if (mpp.containsKey(res)) {
                cnt += mpp.get(res);
                mpp.put(res, mpp.get(res) + 1);
            } else {
                mpp.put(res, 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        int []arr = {-1,2,9};
        int k=2;
        System.out.println(subarraysDivByK(arr,k));
//        System.out.println(10%5); //  0
//        System.out.println(5%10); //  5
//        System.out.println(-10%5); // 0
//        System.out.println(-5%10); // -5
    }
}
