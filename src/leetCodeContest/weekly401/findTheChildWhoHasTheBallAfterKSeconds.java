package leetCodeContest.weekly401;

public class findTheChildWhoHasTheBallAfterKSeconds {
    public static int numberOfChild(int n, int k) {

        boolean isFound = true;
        int cnt =-1;
        while(isFound){
            for(int i=0; i<n; i++){
                cnt++;
                if(cnt == k)return i;
            }
            for(int i=n-2; i>0; i--){
                cnt++;
                if(cnt == k)return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(numberOfChild(3,5));
    }
}
