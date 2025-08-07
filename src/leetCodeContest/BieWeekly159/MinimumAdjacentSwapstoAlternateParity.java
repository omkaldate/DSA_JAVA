package leetCodeContest.BieWeekly159;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumAdjacentSwapstoAlternateParity {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) evens.add(i);
            else odds.add(i);
        }

        if (Math.abs(evens.size() - odds.size()) > 1) return -1;

        int minSwaps = Integer.MAX_VALUE;

        if (evens.size() >= odds.size()) {
            minSwaps = Math.min(minSwaps, calculateSwaps(evens));
        }

        if (odds.size() >= evens.size()) {
            minSwaps = Math.min(minSwaps, calculateSwaps(odds));
        }

        return minSwaps;
    }

    private int calculateSwaps(List<Integer> indices) {
        int swaps = 0;
        for (int i = 0; i < indices.size(); i++) {
            swaps += Math.abs(indices.get(i) - (2 * i));
        }
        return swaps;
    }


    public static void main(String[] args) {

    }
}
