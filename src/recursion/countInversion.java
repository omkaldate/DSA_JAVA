package recursion;

import java.util.Arrays;

public class countInversion {
    public static void main(String[] args){
            int[] arr = {5,3,2,4,1};
            int count = merge(arr,0,arr.length-1);
             System.out.println(Arrays.toString(arr));
             System.out.println(count);

    }

    public static int merge(int[]arr ,int s , int e ){
        int count = 0;

        if(s >= e){
            return count;
        }
        int m = s+(e-s)/2;
        count += merge(arr,s,m);
        count += merge(arr,m+1,e);
        count += sort(arr,s,m,e);

        return count;
    }

    public static int sort(int[]arr , int str , int mid , int end) {
        int[] arr1 = new int[end - str + 1];
        int ans =0;
        int i = str;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                arr1[k] = arr[i];
                    i++;
                    k++;
                }
            else{
                arr1[k] = arr[j];
                k++;
                j++;
                ans += mid-i+1;
            }
        }
        while(i<= mid){
            arr1[k] = arr[i];
            k++;
            i++;

        }
        while(j<= end){
            arr1[k] = arr[j];
            k++;
            j++;
        }

        for(int x=0 ; x<arr1.length; x++){
            arr[str+x] = arr1[x];
        }

        return ans;
    }

}
