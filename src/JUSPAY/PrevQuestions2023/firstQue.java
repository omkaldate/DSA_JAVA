package JUSPAY.PrevQuestions2023;

import java.util.Arrays;
import java.util.Scanner;

public class firstQue {

    public static int func(int N, int[]graph){
        int[]sum = new int[N];
        int ans = 0;
        int node = -1;

        for(int i=0; i<N; i++){
            if(graph[i] < 0) continue;
            sum[graph[i]] += i;
            if(ans < sum[graph[i]]){
                ans =  sum[graph[i]];
                node = graph[i];
            }
        }

        return node;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();

        while(tCases-- > 0){

            int N = sc.nextInt();
            int[]graph = new int[N];
            for(int i=0; i<N; i++){
                graph[i] = sc.nextInt();
            }

            int ans = func(N, graph);
            System.out.println(ans);
        }
    }
}
