package Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MorisTraversal {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return inorder;
    }

    public static void main(String[] args) {
        MorisTraversal tree = new MorisTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> inorderTraversal = tree.getInorder(root);
        System.out.println(inorderTraversal);
    }
}



