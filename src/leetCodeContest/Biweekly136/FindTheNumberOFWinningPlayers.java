package leetCodeContest.Biweekly136;

import java.util.HashMap;

public class FindTheNumberOFWinningPlayers {
    public static int winningPlayerCount(int n, int[][] pick) {

        int ans =0;

        for(int i=0; i<n; i++){
            HashMap<Integer,Integer> mpp = new HashMap<>();

            for(int[]x :pick){
                int player = x[0];
                int color = x[1];

                if(player == i){
                    mpp.put(color , mpp.getOrDefault(color ,0)+1);
                    if(mpp.get(color) > i) {
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][]arr = {
                {0,0},
                {1,0},
                {1,0},
                {2,1},
                {2,1},
                {2,0}
        };

        System.out.println(winningPlayerCount(4,arr));
    }
}
