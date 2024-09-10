package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Dijkstra_TreeSet {

    static class Node {
        int value;
        int dist;

        Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Node> set = new TreeSet<>((node1, node2) -> {
            if (node1.dist != node2.dist) {
                return node1.dist - node2.dist;
            }
            return node1.value - node2.value;
        });

        set.add(new Node(S, 0));
        int[] dist = new int[V];
        Arrays.fill(dist,(int) 1e9);
        dist[S] = 0;

        while (!set.isEmpty()) {
            Node node = set.pollFirst();

            for (ArrayList<Integer> adjNodes : adj.get(node.value)) {
                int adjNode = adjNodes.get(0);
                int adjNodeDist = adjNodes.get(1);

                if (dist[node.value] + adjNodeDist < dist[adjNode]) {
//                     if(dist[adjNode] != 1e9){
//                         set.remove(Node(adjNodeDist,dist[adjNode]));
//                     }
                    dist[adjNode] = dist[node.value] + adjNodeDist;
                    set.add(new Node(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(0).add(new ArrayList<>(List.of(1, 2)));
        adj.get(0).add(new ArrayList<>(List.of(2, 4)));
        adj.get(1).add(new ArrayList<>(List.of(2, 1)));
        adj.get(1).add(new ArrayList<>(List.of(3, 7)));
        adj.get(2).add(new ArrayList<>(List.of(3, 3)));
        adj.get(3).add(new ArrayList<>(List.of(4, 1)));

        int source = 0;
        int[] distances = dijkstra(V, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + distances[i]);
        }
    }
}
