package REVISION.Rrcursion;

public class binarySearch {

    public static int isPrese(int[]arr,int s,int e,int target){
        if(s>e)return -1;

        int m = s+(e-s)/2;
        if(arr[m] == target)return m;

        if(arr[s] <= arr[m]){
            if(target <= arr[m] && target >= arr[s]){
               return isPrese(arr,s,m-1,target);
            }
            else{
                return isPrese(arr,m+1,e,target);
            }
        }
        else{
            if(target >=arr[m] && target <= arr[e]){
                return isPrese(arr,m+1,e,target);
            }
            else{
                return isPrese(arr,s,m-1,target);
            }
        }


    }


    public static void main(String[] args) {
     int[]arr={5,6,7,8,9,1,2,3,4};
        System.out.println(isPrese(arr,0,arr.length-1,8));
    }
}
