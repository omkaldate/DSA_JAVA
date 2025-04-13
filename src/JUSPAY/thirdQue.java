package JUSPAY;
import java.util.*;

public class thirdQue {

    public static int fun(int N, int[]graph){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int N = sc.nextInt();
            int[]graph = new int[N];
            for(int i=0; i<N; i++){
                graph[i] = sc.nextInt();
            }

            int ans = fun(N, graph);
            System.out.println(ans);
            sc.close();
        }
    }
}
