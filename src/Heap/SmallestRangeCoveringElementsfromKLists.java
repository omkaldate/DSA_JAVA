package Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsfromKLists {

    public class Node {
        int val, row, col;
        Node(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<Node> q = new PriorityQueue<Node>(k, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.val < n2.val)
                    return -1;
                else if(n1.val == n2.val)
                    return 0;
                else
                    return 1;
            }
        });

        int max = Integer.MIN_VALUE;
        int lower=0, upper=0;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i < k; i++)
        {
            int e = nums.get(i).get(0);
            max = Math.max(max, e);
            q.add(new Node(e, i, 0));
        }

        while(!q.isEmpty())
        {
            Node curr = q.poll();

            if(max - curr.val < diff)
            {
                diff = max - curr.val;
                lower = curr.val;
                upper = max;
            }

            if(curr.col < nums.get(curr.row).size() - 1 ) {

                q.offer(new Node(nums.get(curr.row).get(curr.col+1), curr.row, curr.col+1));

                max = Math.max(max, nums.get(curr.row).get(curr.col+1));
            }
            else
                break;
        }

        int[] range = new int[2];
        range[0] = lower;
        range[1] = upper;

        return range;
    }



    
    public static void main(String[] args) {


    }
}
