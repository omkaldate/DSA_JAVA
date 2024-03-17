package leetcode_Questions;

public class buque_flower_bs_1482 {

    public static void main(String[] args){

        int[]bloomDay = { 4,7,9,4,2,7,5,7};
        System.out.println(minDays(bloomDay ,3,2));


    }

    public static  int minDays(int[] bloomDay, int m, int k) {

        long val = m*k;
        if(val > bloomDay.length) return -1;
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;

        for(int i=0 ; i< bloomDay.length ; i++){
             s =Math.min(s , bloomDay[i]);
             e = Math.max(e , bloomDay[i]);
        }

        while(s <= e){
            int mid = s+(e-s)/2;
            if(possible(bloomDay , mid , m , k)) e =mid-1;
            else s = mid+1;
        }
        return s;

    }


    public  static boolean possible(int []arr , int day , int m , int k){
        int cnt =0;
        int noOfB=0;
        for(int i=0; i<arr.length ; i++){
            if(arr[i] <= day ){
                cnt++;
            }
            else{
                noOfB += cnt/k;
                cnt=0;
            }
        }

        noOfB += cnt/k;
        return noOfB >= m;

    }

}
