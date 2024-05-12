package leetCodeContest.Weekly397;

import java.util.HashMap;
import java.util.Map;

public class TakingMaximumEnergyFromtheMysticDungeon {
//    public static int maximumEnergy(int[] energy, int k) {
//        int n = energy.length;
//        int maxi = Integer.MIN_VALUE;
//        ;
//        int sum = 0;
//
//        if (k == 0) {
//            for (int i = 0; i < n; i++) {
//                maxi = Math.max(maxi, energy[i]);
//
//            }
//            return maxi;
//        }
//
//        int x = 0;
//        for (int i = 0; i < n; i++) {
//            while ((i + x) < n) {
//                sum += energy[i + x];
//                x += k;
//            }
//            maxi = Math.max(maxi, sum);
//            sum = 0;
//            x = 0;
//        }
//
//        for (int i = n - k; i < n; i++) {
//            maxi = Math.max(maxi, energy[i]);
//        }
//        return maxi;
//    }


    public static int maximumEnergy(int[] energy, int k) {
    Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < energy.length; i++) {
        int index = i % k;

        if(map.containsKey(index)) {
            int val = map.get(index) + energy[i];

            if(energy[i] > val) {
                map.put(index, energy[i]);
            }
            else {
                map.put(index, val);
            }
        }
        else {
            map.put(index, energy[i]);
        }
    }
    //System.out.println(map);

    int maxi = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
        maxi = Math.max(maxi, mp.getValue());
    }
        return maxi;
    }

    public static void main(String[] args){
        int[]arr = {5,2,-10,-5,1};
        int k=3;
        System.out.println(maximumEnergy(arr , k));
    }
}
