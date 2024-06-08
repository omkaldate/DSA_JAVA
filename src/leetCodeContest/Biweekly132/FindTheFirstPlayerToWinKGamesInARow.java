package leetCodeContest.Biweekly132;

import java.util.HashMap;

public class FindTheFirstPlayerToWinKGamesInARow {
    public static int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;

        HashMap<Integer, Integer> inx = new HashMap<>();
        int maxi =0;
        for (int i = 0; i < n; i++) {
            inx.put(skills[i], i);
            maxi = Math.max(maxi, skills[i]);
        }
        if (k >= n-1) return inx.get(maxi);

        HashMap<Integer, Integer> findk = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (skills[0] > skills[1]) {
                int x = skills[1];
                for (int j = 1; j < n - 1; j++) {
                    skills[j] = skills[j + 1];
                }
                skills[n - 1] = x;
            } else {
                int y = skills[0];
                for (int j = 0; j < n - 1; j++) {
                    skills[j] = skills[j + 1];
                }
                skills[n - 1] = y;
            }

            if (findk.containsKey(skills[0])) {
                findk.put(skills[0], findk.get(skills[0]) + 1);
            } else {
                findk.put(skills[0], 1);
            }
            if(findk.get(skills[0]) == k)  return inx.get(skills[0]);
        }
        return inx.get(maxi);
    }

    public static void main(String[] args){
        int[]skills = {3,11,7,17,15,4,6,19};
        int k=5;
        System.out.println(findWinningPlayer(skills,k));
    }

}
