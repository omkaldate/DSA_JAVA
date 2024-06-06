package array;

import java.util.Arrays;
import java.util.HashMap;

public class handOFStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(hand[i])) {
                mp.put(hand[i], mp.get(hand[i]) + 1);
            }
            else {
                mp.put(hand[i], 1);
            }
        }
        Arrays.sort(hand);

        for (int key : hand) {
            if (mp.get(key) > 0) {
                for (int j = 0; j < groupSize; j++) {
                    if (!mp.containsKey(key + j) || mp.get(key + j) == 0)
                        return false;
                    mp.put(key + j, mp.get(key + j) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int []hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand , groupSize));
    }
}
