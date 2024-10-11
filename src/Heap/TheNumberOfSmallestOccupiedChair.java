package Heap;

import java.util.*;

public class TheNumberOfSmallestOccupiedChair {

    private static class Friend {
        public final int number;
        public final int start;
        public final int end;
        public int chair;

        public Friend(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "n: " + number + " s: " + start + " e: " + end + " chair: " + chair;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<Friend> q = new PriorityQueue<>((f1, f2) -> f1.end - f2.end);
        int n = times.length;
        List<Friend> ar = new ArrayList<>();
        for (int i = 0; i < times.length; ++i) {
            Friend f = new Friend(i, times[i][0], times[i][1]);
            ar.add(f);
        }
        Collections.sort(ar, (f1, f2) -> f1.start - f2.start);
        Queue<Integer> minChairQ = new PriorityQueue<>();
        for (Friend f: ar) {
            if (!q.isEmpty()) {
                while (!q.isEmpty() && q.peek().end <= f.start) {
                    Friend polled = q.poll();
                    minChairQ.add(polled.chair);
                }
            }
            int minChair = 0;
            if (minChairQ.isEmpty()) minChair = q.size();
            else minChair = minChairQ.poll();
            f.chair = minChair;
            q.add(f);
            if (f.number == targetFriend) return f.chair;
        }
        return -1;
    }


    public static void main(String[] args) {
        
    }
}
