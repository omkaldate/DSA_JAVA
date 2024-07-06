package array;

public class PassThePillo {
    public static int passThePillow(int n, int time) {
        if(time < n) return time + 1;
        int divide = (time/(n-1));
        int mod = time % (n - 1);
        int ans = 1;

        if((divide % 2) == 0){
            for(int i=1; i<=mod; i++){
                ans++;
            }
        }
        else{
            ans = n;
            while(mod > 0) {
                ans--;
                mod--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(passThePillow(4,5));
    }
}
