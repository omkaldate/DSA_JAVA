package RECURSION_REVISION;

import java.util.LinkedList;
import java.util.Queue;

public class knightWalk {

    static class Tuple{
        int r;
        int c;

        Tuple(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static  int minStepToReachTarget(int kPos[], int tPos[], int N){
        N++;

        if(kPos[0] == tPos[0] && kPos[1] == tPos[1]) return 0;

        int[][]mat = new int[N][N];

        mat[tPos[0]][tPos[1]] = 100;

        int[]dx = {-2,-2,-1,1,2,2,1,-1};
        int[]dy = {-1,1,2,2,1,-1,-2,-2};

        Queue<Tuple> qu = new LinkedList<>();

        Tuple tp = new Tuple(kPos[0],kPos[1]);
        qu.offer(tp);
        mat[kPos[0]][kPos[1]] = 1;

        int ans = 1;

        while(!qu.isEmpty()){
            int size = qu.size();

            for(int i=0; i<size; i++){
                Tuple t = qu.poll();
                int r = t.r;
                int c = t.c;

                for(int x=0; x<8; x++){
                    int row = r + dx[x];
                    int col = c + dy[x];

                    if(row <1 || row>= N || col <1 || col>= N) continue;
                    if(mat[row][col] == 1) continue;
                    if(mat[row][col] == 100) return ans;
                    mat[row][col] = 1;

                    Tuple tup = new Tuple(row,col);
                    qu.offer(tup);
                }
            }
            ans++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int N= 6;
        int[] kp = {4,5};
        int[]tp = {1,1};

        System.out.println(  minStepToReachTarget(kp,tp,N)  );
    }
}
