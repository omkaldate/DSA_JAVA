package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumbersOfGroups {
    public static int minGroups(int[][] intervals) {

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int[] inte: intervals){
            int start = inte[0];
            int end = inte[1];

            if(!pq.isEmpty() && pq.peek()<start) pq.remove();
            pq.add(end);
        }
        return pq.size();
    }

    public static void main(String[] args) {

    }
}
