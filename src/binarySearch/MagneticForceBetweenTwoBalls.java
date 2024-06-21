package binarySearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n = pos.length;
        int l = 1, r = pos[n-1], ans = 0;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(isValid(mid, pos, m)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    static boolean isValid(int mid, int[] pos, int m)
    {
        int countBalls = 1, prevIndex = 0;
        for(int i=1; i<pos.length; i++)
        {
            if(pos[i]-pos[prevIndex] >= mid)
            {
                ++countBalls;
                prevIndex = i;
            }
        }

        return countBalls >= m;
    }




    public static void main(String[] args){
        int[]position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position,m));
    }

}
