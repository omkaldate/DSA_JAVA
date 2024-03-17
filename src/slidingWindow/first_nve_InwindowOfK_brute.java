package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class first_nve_InwindowOfK_brute {
    public static void main(String[] args){
        int[] arr={2,-1,-7,8,-15,30,16,28};
        int k=3;
        System.out.println(funk(arr , k));
    }


    public static ArrayList<Integer> funk(int[]arr , int k){
        int n= arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;

        while(j<n){
            if(j-i+1 == k){
                for(int index=i ; index<=j ; index++){
                    if(arr[index]<0){
                        ans.add(arr[index]);
                        i++;
                        break;
                    }

                }
            }
            j++;
        }
        return ans;
    }
}
