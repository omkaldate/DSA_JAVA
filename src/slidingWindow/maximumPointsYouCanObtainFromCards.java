package slidingWindow;

public class maximumPointsYouCanObtainFromCards {

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int i = 0;
        int j = 0;
        int sum =0;
        int ans = 0;
        int val =0;

        for(int x=0; x<n; x++) {
            sum += cardPoints[x];
        }

        if(k == n) return sum;

        while(j<n){
            val += cardPoints[j];

            if(j-i+1 == n-k){
                ans = Math.max((sum - val) , ans);
                val -= cardPoints[i];
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {100,40,17,9,73,75};
        System.out.println(maxScore(arr,3));
    }
}
