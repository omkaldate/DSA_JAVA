package JUSPAY;

import java.util.*;


public class secQue {

    public static  void bfs(int[] edges, int startNode, int[] dist , int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(startNode);
        visited[startNode] = true;
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u];
            if (v != -1 && !visited[v]) {
                dist[v] = dist[u] + 1;
                visited[v] = true;
                queue.offer(v);
            }
        }
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
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            int n = graph.length;
            int[] dist1 = new int[n];
            int[] dist2 = new int[n];
            Arrays.fill(dist1, Integer.MAX_VALUE);
            Arrays.fill(dist2, Integer.MAX_VALUE);

            bfs(graph, node1, dist1, n);
            bfs(graph, node2, dist2 , n);

            int node = -1;
            int minDistTillNow = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                    int maxDist = Math.max(dist1[i], dist2[i]);
                    if (maxDist < minDistTillNow) {
                        minDistTillNow = maxDist;
                        node = i;
                    }
                }
            }
            System.out.println(node);
            sc.close();
        }
    }
}
