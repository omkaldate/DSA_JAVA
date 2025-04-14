package JUSPAY;
import java.util.*;

public class thirdQue {

    public static int fun(int N, int[]graph){

        ArrayList<Integer> sum = new ArrayList<>();
            for(int i=0; i<N; i++){
                int j = i;
                ArrayList<Integer> path = new ArrayList<>();
                int s = 0;
                while(graph[j]!=i && graph[j]!=-1 && !path.contains(j)){
                        path.add(j);
                        s+= j;
                        j = graph[j];
                        if(graph[j] == j){
                            s += j;
                            break;
                        }
                }
                if(graph[j] == i) sum.add(s);
            }

            if(sum.isEmpty()) return -1;

            return Collections.max(sum);
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
