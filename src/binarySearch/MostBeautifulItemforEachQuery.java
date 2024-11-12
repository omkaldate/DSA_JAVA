package binarySearch;

import java.util.Arrays;

public class MostBeautifulItemforEachQuery {
    public static int[] maximumBeauty(int[][] items, int[] queries) {

        int querySize = queries.length,itemSize = items.length;
        int [] result = new int[querySize];

        Arrays.sort(items,(a, b) -> Integer.compare(a[1],b[1]));
        for(int i = 0 ; i < querySize ;i++) {
            for(int j = itemSize - 1;j >= 0 ;j--) {
                if(items[j][0] <= queries[i]) {
                    result[i] = items[j][1];
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        
    }
}
