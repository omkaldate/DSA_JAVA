package practiceJuspay;
import java.util.Arrays;

public class heapSort {

    public static void heapSort(int[] arr , int n){
            for(int i = n/2; i>=0; i--){
                heapify(arr,n, i);
            }

            while(n >= 0){
                swap(arr, 0, n);
                n--;
                heapify(arr, n, 0);
            }
    }

    public static  void heapify(int[]arr, int n, int i){
        int left = 2*i +1;
        int right = 2*i +2;
        int maxi = i;

        if(left <=n && arr[left] > arr[maxi]){
            maxi = left;
        }
        if(right <=n && arr[right] > arr[maxi]){
            maxi = right;
        }

        if(maxi != i){
            swap(arr, i, maxi);
            heapify(arr,n,maxi);
        }
    }

    public static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String [] args){
        int[]arr = {9,8,7,6,5,34,23,67,0,4,3,2,1};
        heapSort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
