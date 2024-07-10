package queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumofMinAndMaxElements {

      public static int sum(int[]arr,int k){
        int sum=0;
        Deque<Integer>dqMin = new ArrayDeque<>();
        Deque<Integer>dqMax = new ArrayDeque<>();

        for(int i=0; i<k; i++){
            while(!dqMin.isEmpty() && arr[dqMin.peekLast()] > arr[i]) dqMin.pollLast();
            dqMin.addLast(i);

            while(!dqMax.isEmpty() && arr[dqMax.peekLast()] < arr[i]) dqMax.pollLast();
            dqMax.addLast(i);
        }

        for(int i=k; i<arr.length; i++){
            sum += arr[dqMin.peekFirst()] + arr[dqMax.peekFirst()];

            while (!dqMin.isEmpty() && dqMin.peekFirst() <= i - k) dqMin.pollFirst();
            while (!dqMax.isEmpty() && dqMax.peekFirst() <= i - k) dqMax.pollFirst();

            while(!dqMin.isEmpty() && arr[dqMin.peekLast()] > arr[i]) dqMin.pollLast();
            dqMin.addLast(i);
            while(!dqMax.isEmpty() && arr[dqMax.peekLast()] < arr[i]) dqMax.pollLast();
            dqMax.addLast(i);
        }
        sum += arr[dqMin.peekFirst()] + arr[dqMax.peekFirst()];

        return sum;
    }

    public static void main(String[] args) {
        int []arr = {2,5,-1,7,-3,-1,-2};
        System.out.println(sum(arr,4));
    }
}
