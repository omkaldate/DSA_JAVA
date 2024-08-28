package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum =0;

        for(int i=0; i<target.length; i++){
            pq.offer(target[i]);
            sum += target[i];
        }

        int maxEle;
        int remSum;
        int element;

        while(pq.peek() != 1){
            maxEle = pq.poll();
            remSum = sum - maxEle;

            if(remSum <=0 || remSum >= maxEle) return false;

            element = maxEle % remSum;
            if(element ==0 ){
                if(remSum == 1) return true;
                else return false;
            }
            sum = remSum+element;
            pq.offer(element);
        }
        return true;
    }


    public static void main(String[] args) {
        int[]arr = {3,9,5};
        System.out.println(isPossible(arr));
    }
}
