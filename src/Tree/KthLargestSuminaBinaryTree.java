package Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSuminaBinaryTree extends BinaryTree{

    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> st = new PriorityQueue<>(k);
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);

        while(!pq.isEmpty()){
            long sum = 0;
            int l = pq.size();
            for(int i=0; i<l; i++){
                TreeNode node = pq.poll();
                sum += node.data;
                if(node.left!=null) pq.add(node.left);
                if(node.right!=null) pq.add(node.right);
            }
            st.add(sum);
            if(st.size()>k) st.poll();
        }
        if(st.size()<k) return -1;
        return st.poll();
    }


    public static void main(String[] args) {

    }
}
