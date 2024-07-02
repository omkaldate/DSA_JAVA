package array;

public class ThreeConsicutiveOdd {
    private static boolean isOdd(int num){
        if((num % 2) !=  0) return true;
        return false;
    }

    public static  boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int cnt =0;

        for(int i =0; i<n; i++){
            if(isOdd(arr[i])){
                cnt++;
                if(cnt ==3)return true;
            }
            else{
                cnt =0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,7,7};
        System.out.println(threeConsecutiveOdds(arr));
    }
}
