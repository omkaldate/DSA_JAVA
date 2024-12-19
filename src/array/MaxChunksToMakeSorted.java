package array;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int sum=0;
        int chunks=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int partition=i*(i+1)/2;
            if(sum==partition) chunks++;
        }
        return chunks;
    }
}
