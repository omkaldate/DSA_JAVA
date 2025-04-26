package practiceJuspay;

import java.util.Arrays;


public class mergeINPlace {

    public static void merge(int[]arr, int s, int e){
        if(e-s == 0) return;

        int m = s+(e-s)/2;

        merge(arr,s,m);
        merge(arr,m+1,e);

        sort(arr,s,m,e);
    }

    public static void sort(int[]arr, int s, int m, int e){
            int[]ans = new int[e-s+1];

            int x = 0;
            int i= s;
            int j = m+1;

            while(i<=m && j<=e){
                if(arr[i] < arr[j]){
                    ans[x++] = arr[i++];
                }
                else ans[x++]= arr[j++];
            }

            while(i<=m){
                ans[x++] = arr[i++];
            }

        while(i<=m){
            ans[x++]= arr[j++];
        }

        x=0;
        for(int k=s; k<=e; k++){
            arr[k] = ans[x++];
        }
    }



    public static void main(String []args){
        int[]arr = {9,8,7,6,5,4,3,2,1};

        merge(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
