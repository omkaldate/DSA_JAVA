package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int k) {
        int[] indegree = new int[k];

        // Calculate indegree of each node
        for (int i = 0; i < k; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Add nodes with indegree 0 to the queue
        for (int x = 0; x < k; x++) {
            if (indegree[x] == 0) q.add(x);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        if(ans.size() != k) return null;
        return ans;
    }

    public static String findOrder(String[] dict, int n, int k) {
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) adj.add(new ArrayList<>());

        // Build the graph
        for (int j = 0; j < n - 1; j++) {
            String s1 = dict[j];
            String s2 = dict[j + 1];
            int len = Math.min(s1.length(), s2.length());

            // Find the first mismatch and build the edge
            boolean foundDifference = false;
            for (int x = 0; x < len; x++) {
                if (s1.charAt(x) != s2.charAt(x)) {
                    adj.get(s1.charAt(x) - 'a').add(s2.charAt(x) - 'a');
                    foundDifference = true;
                    break;
                }
            }
            if (!foundDifference && s1.length() > s2.length()) {
                return ""; // Invalid dictionary order
            }
        }

        // Perform topological sort
        ArrayList<Integer> list = topoSort(adj, k);
        if(list == null) return "";
        StringBuilder ans = new StringBuilder();
        for (int z : list) {
            ans.append((char) ('a' + z));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict,5,4));
    }
}
