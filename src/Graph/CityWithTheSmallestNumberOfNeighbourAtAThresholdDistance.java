package Graph;

public class CityWithTheSmallestNumberOfNeighbourAtAThresholdDistance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            matrix[u][v] = weight;
            matrix[v][u] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)  continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int cityNo = -1;
        int minReachableCities = n;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                cityNo = i;
            }
        }

        return cityNo;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,1,3},
                {1,2,1},
                {1,3,4},
                {2,3,1}
        };
        System.out.println(findTheCity(4,arr,4));
    }
}
