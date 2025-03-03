package array;

public class PartitionArrayAccordingtoGivenPivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int[] ans = new int[n];
        int pCnt = 0;

        int x = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == pivot) pCnt++;
            if(nums[i] < pivot) ans[x++] = nums[i];
        }

        while(pCnt != 0){
            ans[x++] = pivot;
            pCnt--;
        }

        for(int i=0; i<n; i++){
            if(nums[i] > pivot) ans[x++] = nums[i];
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
