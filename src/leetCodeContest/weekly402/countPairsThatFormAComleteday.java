package leetCodeContest.weekly402;

public class countPairsThatFormAComleteday {
    public static int countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int cnt =0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((hours[i]+hours[j])%24 == 0){
                    System.out.println(i+ ""+ j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int []arr = {12,12,30,24,24};
        System.out.println(countCompleteDayPairs(arr));
    }
}
