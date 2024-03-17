
package leetcode_Questions;
import java.util.*;

public class _15_3Sum {
    public static void main(String[] args){
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }


    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static class _3005_cuntElementsWithMaxOccurance {
        public static void main(String[] args){
            int[]arr = {3,4,5,6,7,8,7,6,5,1,9,07};
            System.out.println(maxFreq(arr));
        }

        public static int maxFreq(int[] nums) {
            int count = 0;
            Map<Integer, Integer> mpp = new HashMap<>();
            int maxFreq = 0;

            for (int num : nums) {
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
                maxFreq = Math.max(maxFreq, mpp.get(num));
            }

            for (int freq : mpp.values()) {
                if (freq == maxFreq)    count += freq;
            }

            return count;

        }
    }
}

