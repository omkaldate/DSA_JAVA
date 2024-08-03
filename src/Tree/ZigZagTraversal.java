package Tree;

import java.util.*;

public class ZigZagTraversal extends BinaryTree {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        boolean LTR = true;

        while (!qu.isEmpty()) {
            int len = qu.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(len, 0));
            for (int i = 0; i <len; i++) {
                TreeNode node = qu.poll();

                int index = LTR ? i : len - 1 - i;
                row.set(index, node.data);

                if (node.left != null) qu.add(node.left);
                if (node.right != null) qu.add(node.right);
            }
            LTR = !LTR;
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagTraversal obj = new ZigZagTraversal();
        obj.createTree();
        System.out.println(zigzagLevelOrder(obj.root));
    }
}
