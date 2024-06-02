package leetCodeContest.weekly400;

public class minimumNumbersOfChairsInWaitingRoom {
    public static int minimumChairs(String s) {
        int n = s.length();
        int maxi =0;
        int cnt =0;

        System.out.println(s);
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'L'){
                cnt--;
            }
            else{
                cnt++;
                maxi = Math.max(maxi,cnt);
            }
        }
        return maxi;
    }

    public static void main(String[] args){
        String s = "ELELEEL";
        System.out.println(minimumChairs(s));
    }
}
