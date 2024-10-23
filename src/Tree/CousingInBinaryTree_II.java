package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousingInBinaryTree_II extends BinaryTree {


    //2 pass
    public TreeNode replaceValueInTree(TreeNode root) {
         if (root == null) return root;

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         List<Integer> levelSum = new ArrayList<>();

         while (!queue.isEmpty()) {
             int currLevelSum = 0;
             int n = queue.size();
             for (int i = 0; i < n; i++) {
                 TreeNode curr = queue.poll();
                 currLevelSum += curr.data;
                 if (curr.left != null) queue.offer(curr.left);
                 if (curr.right != null) queue.offer(curr.right);
             }
             levelSum.add(currLevelSum);
         }

         queue.add(root);
         root.data = 0;
         int level = 1;
         while (!queue.isEmpty()) {
             int n = queue.size();

             for (int i = 0; i < n; i++) {
                 TreeNode curr = queue.poll();

                 int siblingSum = (curr.left != null ? curr.left.data : 0) + (curr.right != null ? curr.right.data : 0);

                 if (curr.left != null) {
                     curr.left.data = levelSum.get(level) - siblingSum;
                     queue.offer(curr.left);
                 }
                 if (curr.right != null) {
                     curr.right.data = levelSum.get(level) - siblingSum;
                     queue.offer(curr.right);
                 }
             }
             level++;
         }
         return root;
     }

     // 1 pass
    public TreeNode replaceV(TreeNode root) {
         if (root == null) return root;

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         int levelSum = root.data;

         while (!queue.isEmpty()) {
             int n = queue.size();
             int nextLevelSum = 0;

             for (int i = 0; i < n; i++) {
                 TreeNode curr = queue.poll();
                 curr.data = levelSum - curr.data;

                 int siblingSum = (curr.left != null ? curr.left.data : 0) + (curr.right != null ? curr.right.data : 0);

                 if (curr.left != null) {
                     nextLevelSum += curr.left.data;
                     curr.left.data = siblingSum;
                     queue.offer(curr.left);
                 }

                 if (curr.right != null) {
                     nextLevelSum += curr.right.data;
                     curr.right.data = siblingSum;
                     queue.offer(curr.right);
                 }
             }
             levelSum = nextLevelSum;
         }
         return root;
     }


    public static void main(String[] args) {




    }

}
