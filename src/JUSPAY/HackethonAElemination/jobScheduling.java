package JUSPAY.HackethonAElemination;

import java.util.Scanner;
import java.util.Arrays;

public class jobScheduling {

    public static  void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }

    public static int function(int[]arr, int s, int e, int k){
        int[]worker = new int[k];
        int ans = -1;

        while(s <= e){
            Arrays.fill(worker, 0);
            int mid = s+(e-s)/2;

            if(recFind(arr,worker,0, mid)){
                ans = mid;
                e = mid-1;
            }
            else s = mid+1;
        }

        return ans;
    }


    public static boolean recFind(int[]arr, int[]worker, int i,  int limit){
        if(i == arr.length) return true;

        for(int x=0; x<worker.length; x++){
            if(worker[x] + arr[i] <= limit){
                worker[x] += arr[i];
                if(recFind(arr,worker,i+1, limit) ) return true;

                worker[x] -= arr[i]; // backtrack
               // if (worker[x] == 0) break; // prune duplicate zero-load branches

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[]arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, n - i - 1);
        }

        int maxi = arr[0];
        int sum = Arrays.stream(arr).sum();

         int ans = function(arr, maxi, sum, k);

        System.out.println(ans);
    }
}
