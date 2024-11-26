package Graph;

public class FindChampion_II {
    public int findChampion(int n, int[][] edges) {
        int len = edges.length;
        int[] arr = new int[n];

        for (int i = 0; i < len; i++) arr[edges[i][1]]++;


        int counter = 0;
        int result = -1;

        for (int i = 0; i < n; i++){
            if (arr[i] == 0){
                counter++;
                if (counter > 1)  return -1;

                if (result == -1) result = i;
            }
        }
        return result;
    }



    public static void main(String[] args) {

    }
}
