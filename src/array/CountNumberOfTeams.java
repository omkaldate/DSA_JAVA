package array;

public class CountNumberOfTeams {
    public static int numTeams(int[] rating) {

        int n = rating.length;
        int cnt =0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;  j++){
                for(int k=j+1; k<n; k++){
                    if(rating[i] < rating[j] && rating[j] < rating[k]) cnt++;
                    if(rating[i] > rating[j] && rating[j] > rating[k]) cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[]arr = {2,5,3,4,1};
        System.out.println(numTeams(arr));
    }
}
