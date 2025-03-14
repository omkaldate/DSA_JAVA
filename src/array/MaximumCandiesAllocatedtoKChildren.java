package array;

public class MaximumCandiesAllocatedtoKChildren {

    public static int maximumCandies(int[] candies, long k) {

        long res=0;
        for(int i=0;i<candies.length;i++) {
            res+=candies[i];
        }
        int fin=0;
        if(res<0)return 0;
        if(res==k)return 1;
        int en = (int)(res/k);
        int st = 1;
        while(st<=en) {
            int mid = st+(en-st)/2;
            long temp=0;
            for(int i=0;i<candies.length;i++) {
                temp+=(candies[i]/mid);
                if(temp>=k) {
                    fin = mid;
                    st = mid + 1;
                    break;
                }
            }
            if(temp<k) {
                en = mid - 1;
            }

        }
        return fin;
    }

    public static void main(String[] args) {

    }
}
